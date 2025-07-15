import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    private TaskManager manager = Managers.getDefault();
    private Task task1;
    private Task task2;
    private Epic epic1;
    private Subtask subtask1;
    private Subtask subtask2;

    @BeforeEach
    void beforeEach() {
        task1 = new Task(1, "Task1", "Description1", TaskStatus.NEW);
        task2 = new Task(2, "Task2", "Description2", TaskStatus.NEW);
        epic1 = new Epic(3, "Epic1", "Description1", TaskStatus.NEW);
        subtask1 = new Subtask(3, 4, "Subtask1", "Desc1", TaskStatus.NEW);
        subtask2 = new Subtask(3, 5, "Subtask2", "Desc2", TaskStatus.NEW);
        manager.createTask(task1);
        manager.createTask(task2);
        manager.createEpic(epic1);
        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);
    }

    @Test
    void shouldAddDifferentTasksAndFindById() {
        final Task savedTask1 = manager.getTaskById(task1.getId());

        assertNotNull(savedTask1, "Задача не найдена");
        assertEquals(task1, savedTask1, "Задачи не совпадают");

        final List<Task> tasks = manager.getAllTasks();

        assertNotNull(tasks, "Задачи не возвращаются");
        assertEquals(2, tasks.size(), "Неверное количество задач.");
        assertEquals(task1, tasks.get(0), "Задачи не совпадают.");
    }

    @Test
    void shouldDoNotConflictWithTasksIds() {
        Task task3 = new Task(2, "Task3", "Description3", TaskStatus.NEW);
        manager.createTask(task3);
        assertEquals(2, task2.getId(), "Такого ид нет");
        assertNotNull(manager.getTaskById(task3.getId()), "Задача с уже существующим ид в базе не может быть добавлена");
        //assertThat(task1.getId()).isEqualTo(1); -- не работает assertThat
    }

    @Test
    void shouldUpdateTaskStatus() {
        task1.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateTask(task1);
        assertEquals(TaskStatus.IN_PROGRESS, manager.getTaskById(1).getStatus(),
                "Статус задачи должен обновляться");
    }

    @Test
    void shouldUpdateEpicStatusWhenSubtasksChange() {
        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask1);
        manager.updateSubtask(subtask2);
        assertEquals(TaskStatus.DONE, manager.getEpicById(3).getStatus(),
                "Статус эпика должен обновляться при изменении подзадач");
    }
}
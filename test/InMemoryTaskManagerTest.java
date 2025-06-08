import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    private TaskManager manager = Managers.getDefault();
    private Task task1;
    private Task task2;

    @BeforeEach
    void beforeEach() {
        task1 = new Task(1, "Task1", "Description1", TaskStatus.NEW);
        task2 = new Task(2, "Task2", "Description2", TaskStatus.NEW);
        manager.createTask(task1);
        manager.createTask(task2);
    }

    @Test
    void addDifferentTasksAndFindById() {
        final Task savedTask1 = manager.getTaskById(task1.getId());

        assertNotNull(savedTask1, "Задача не найдена");
        assertEquals(task1, savedTask1, "Задачи не совпадают");

        final List<Task> tasks = manager.getAllTasks();

        assertNotNull(tasks, "Задачи не возвращаются");
        assertEquals(2, tasks.size(), "Неверное количество задач.");
        assertEquals(task1, tasks.get(0), "Задачи не совпадают.");
    }

    @Test
    void taskDoNotConflictWithIds() {
        Task task3 = new Task(2, "Task3", "Description3", TaskStatus.NEW);
        manager.createTask(task3);
        assertEquals(2, task2.getId(), "Такого ид нет");
        assertNotNull(manager.getTaskById(task3.getId()), "Задача с уже существующим ид в базе не может быть добавлена");
        //assertThat(task1.getId()).isEqualTo(1); -- не работает assertThat

    }

}
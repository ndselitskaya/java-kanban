import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    HistoryManager historyManager = Managers.getDefaultHistory();
    private TaskManager taskManager = Managers.getDefault();
    private Task task1;
    private Task task2;
    private Epic epic1;

    @BeforeEach
    void beforeEach() {
        task1 = new Task(1, "Task1", "Description1", TaskStatus.NEW);
        task2 = new Task(2, "Task2", "Description2", TaskStatus.NEW);
        epic1 = new Epic(3, "Epic1", "Description1", TaskStatus.IN_PROGRESS);
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createEpic(epic1);
        historyManager.add(task1);
        historyManager.add(task2);
        historyManager.add(epic1);
    }

    @Test
    void addTasksToHistoryManager() {
        List<Task> history = historyManager.getHistory();
        assertNotNull(history, "После добавления задач, история не должна быть пустой.");
        assertEquals(3, history.size(), "После добавления задачи, история не должна быть пустой.");
    }

    @Test
    void addedTaskShoudBeAtTheEndOfTheList(){
        Epic epic2 = new Epic(4, "Epic2", "Description2", TaskStatus.IN_PROGRESS);
        historyManager.add(epic2);
        List<Task> history = historyManager.getHistory();
        assertEquals(3, history.indexOf(epic2), "Добавленная задача должна быть в конце списка");
    }

    @Test
    void oldVersionTaskShoudBeSavedAfterUpdate(){
        List<Task> history = historyManager.getHistory();
        Task oldTask = task1;
        int idOldTask = history.indexOf(task1);
        task1.setStatus(TaskStatus.IN_PROGRESS);
        historyManager.add(task1);
        assertEquals(oldTask, history.get(idOldTask), "Прошлая версия задачи должна быть в списке");
    }
}
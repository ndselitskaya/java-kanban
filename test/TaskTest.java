import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task1;
    private Task task2;

    @BeforeEach
    void beforeEach() {
        task1 = new Task(1, "Task1", "Description1", TaskStatus.NEW);
        task2 = new Task(1, "Task2", "Description2", TaskStatus.NEW);
    }

    @Test
    void tasksWithSameIdShouldBeEqual() {
        assertEquals(task1, task2, "Задачи с одинаковым id должны быть равны");
        assertEquals(task1.hashCode(), task2.hashCode(), "HashCode должен совпадать");
    }

    @Test
    void tasksWithDifferentIdShouldNotBeEqual() {
        Task task2 = new Task(2, "Task2", "Description2", TaskStatus.NEW);
        assertNotEquals(task1, task2, "Задачи с разным id не должны быть равны");
    }

    //неизменность задачи (по всем полям) при добавлении задачи в менеджер
    //*ид в данной программе может отличаться
    @Test
    void tasksShouldBeEqualsByAddingInMeneger() {
        TaskManager manager = Managers.getDefault();
        manager.createTask(task1);
        Task savedTask = manager.getTaskById(task1.getId());
        assertEquals(savedTask, task1);
    }
}
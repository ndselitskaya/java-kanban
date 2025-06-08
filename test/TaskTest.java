import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void tasksWithSameIdShouldBeEqual() {
        Task task1 = new Task(1, "Task1", "Description1", TaskStatus.NEW);
        Task task2 = new Task(1, "Task2", "Description2", TaskStatus.NEW);

        assertEquals(task1, task2, "Задачи с одинаковым id должны быть равны");
        assertEquals(task1.hashCode(), task2.hashCode(), "HashCode должен совпадать");
    }

    @Test
    void tasksWithDifferentIdShouldNotBeEqual() {
        Task task1 = new Task(1, "Task1", "Description1", TaskStatus.NEW);
        Task task2 = new Task(2, "Task2", "Description2", TaskStatus.NEW);

        assertNotEquals(task1, task2, "Задачи с разным id не должны быть равны");
    }
}
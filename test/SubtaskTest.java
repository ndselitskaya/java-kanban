import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {

    @Test
    void subtasksWithSameIdShouldBeEqual() {
        Subtask subtask1 = new Subtask(1, 5, "Subtask1", "Description1", TaskStatus.IN_PROGRESS);
        Subtask subtask2 = new Subtask(2, 5, "Subtask2", "Description2", TaskStatus.IN_PROGRESS);

        assertEquals(subtask1, subtask2, "Подзадачи с одинаковым id должны быть равны");
        assertEquals(subtask1.hashCode(), subtask2.hashCode(), "HashCode должен совпадать");
    }

    @Test
    void subtasksWithDifferentIdShouldNotBeEqual() {
        Subtask subtask1 = new Subtask(1, 3, "Subtask1", "Description1", TaskStatus.IN_PROGRESS);
        Subtask subtask2 = new Subtask(2, 4, "Subtask2", "Description2", TaskStatus.IN_PROGRESS);

        assertNotEquals(subtask1, subtask2, "Подзадачи с разным id не должны быть равны");
    }

}
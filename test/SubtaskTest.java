import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    TaskManager manager = Managers.getDefault();

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

    @Test
    void SubtaskCannotBeSubtaskOfNullEpic() {
        Epic epic1 = new Epic(1, "Epic1", "Description1", TaskStatus.NEW);
        Subtask subtask1 = new Subtask(epic1.getId(), 1, "Subtask1", "Description1", TaskStatus.NEW);

        assertThrows(IllegalArgumentException.class, () -> {
            manager.createSubtask(subtask1);
        }, "Эпика с таким ид нет");
    }

    @Test
    void SubtaskCannotBeEpic() {

        Subtask subtask1 = new Subtask(1, 1, "Subtask1", "Description1", TaskStatus.NEW);

        assertThrows(IllegalArgumentException.class, () -> {
            manager.createSubtask(subtask1);
        }, "Подзадача не может быть своим же эпиком");
    }
}

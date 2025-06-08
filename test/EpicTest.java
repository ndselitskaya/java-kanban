import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    void epicsWithSameIdShouldBeEqual() {
        Epic epic1 = new Epic(3, "Epic1", "Description1", TaskStatus.IN_PROGRESS);
        Epic epic2 = new Epic(3, "Epic1", "Description1", TaskStatus.IN_PROGRESS);

        assertEquals(epic1, epic2, "Эпики с одинаковым id должны быть равны");
        assertEquals(epic1.hashCode(), epic2.hashCode(), "HashCode должен совпадать");
    }

    @Test
    void epicsWithDifferentIdShouldNotBeEqual() {
        Epic epic1 = new Epic(3, "Epic1", "Description1", TaskStatus.IN_PROGRESS);
        Epic epic2 = new Epic(4, "Epic1", "Description1", TaskStatus.IN_PROGRESS);

        assertNotEquals(epic1, epic2, "Эпики с разным id не должны быть равны");}
}
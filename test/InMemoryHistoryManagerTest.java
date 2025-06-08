import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    @Test
    void returnInitializedTaskManager() {
        TaskManager manager1 = Managers.getDefault();
        assertNotNull(manager1);
        HistoryManager manager2 = Managers.getDefaultHistory();
        assertNotNull(manager2);
        assertNotEquals(manager1, manager2, "Объекты должны быть разными");
    }
}
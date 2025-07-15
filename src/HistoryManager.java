import java.util.List;

public interface HistoryManager {

    void add(Task task);
    void remove(int id); //удаление повторного просмотра задачи
    List<Task> getHistory();
}

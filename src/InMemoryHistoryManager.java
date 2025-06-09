import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{

    private final List<Task> historyTasks= new ArrayList<>();

    //метод добавления просмотренной задачи в кеш
    @Override
    public void add(Task task) {
        historyTasks.add(task);
        if (historyTasks.size()>10){
            historyTasks.removeFirst();
        }
    }

    //метод просмотра истории задач
    @Override
    public List<Task> getHistory(){
        System.out.println(historyTasks);
        return historyTasks;
    }
}

import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager{

    private final ArrayList<Task> historyTasks= new ArrayList<>();
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
    public ArrayList<Task> getHistory(){
        System.out.println(historyTasks);
        return historyTasks;
    }
}

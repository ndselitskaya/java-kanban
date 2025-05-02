import java.util.HashMap;
//коммит пупупу
//класс для работы с задачами
public class TaskManager {
    private int counter = 0; //поле счетчик для ид
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

    //методы создания задач
    public Task createTask(Task task){
        if (task.getId() == null) {
            task.setId(generateId());
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public Subtask createSubtask(Subtask subtask){
        if (subtask.getId() == null) {
            subtask.setId(generateId());
        }
        tasks.put(subtask.getId(), subtask);
        return subtask;
    }

    public Epic createEpic(Epic epic){
        if (epic.getId() == null) {
            epic.setId(generateId());
        }
        tasks.put(epic.getId(), epic);
        return epic;
    }

    //методы получения списка всех задач
    public void getAllTasks(){
        for(Task task: tasks.values()){
            System.out.println(task);
        }
    }

    public void getAllSubtasks(){
        for(Subtask subtask: subtasks.values()){
            System.out.println(subtask);
        }
    }

    public void getAllEpics(){
        for(Epic epic: epics.values()){
            System.out.println(epic);
        }
    }

    //методы удаления всех задач
    public void deleteAllTasks(){
        tasks.clear();
    }

    public void deleteAllSubtasks(){
        subtasks.clear();
    }

    public void deleteAllEpics(){
        epics.clear();
    }

    //методы получения списка задач по id
    public void getTaskById(Integer id){
        if (tasks.containsKey(id)){
            System.out.println(tasks.get(id));
        } else {
            System.out.println("Задачи с таким ид нет");
        }
    }

    public void getSubtaskById(Integer id){
        if (subtasks.containsKey(id)){
            System.out.println(subtasks.get(id));
        } else {
            System.out.println("Подзадачи с таким ид нет");
        }
    }

    public void getEpicById(Integer id){
        if (epics.containsKey(id)){
            System.out.println(epics.get(id));
        } else {
            System.out.println("Эпика с таким ид нет");
        }
    }

    public int generateId(){
        counter++;
        return counter;
    }

}

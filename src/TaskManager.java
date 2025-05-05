import java.util.ArrayList;
import java.util.HashMap;
//класс для работы с задачами
public class TaskManager {
    private int counter = 0; //поле счетчик для ид
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

    //методы создания задач
    public Task createTask(Task task){
        if (task.getId() != null) {
            task.setId(generateId());
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public Subtask createSubtask(Subtask subtask){
        if (subtask.getId() != null) {
            subtask.setId(generateId());
        }
        subtasks.put(subtask.getId(), subtask);
        return subtask;
    }

    public Epic createEpic(Epic epic){
        if (epic.getId() != null) {
            epic.setId(generateId());
        }
        epics.put(epic.getId(), epic);
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

    //методы обновления задач
    public void updateTask(Task task){
        if (tasks.containsKey(task.getId())){
            tasks.put(task.getId(), task);
        } else {
            System.out.println("Такой задачи нет");
        }
    }

    public void updateSubtask(Subtask subtask){
        if (subtasks.containsKey(subtask.getId())){
            subtasks.put(subtask.getId(), subtask);
            changeEpicStatus(subtask.getIdEpic());
        } else {
            System.out.println("Такой подзадачи нет");
        }
    }

    public void updateEpic(Epic epic){
        if (epics.containsKey(epic.getId())){
            epics.put(epic.getId(), epic);
        } else {
            System.out.println("Такого эпика нет");
        }
    }

    //методы удаления задач по ид
    public void deleteTaskById(Integer id){
        if (tasks.containsKey(id)){
            tasks.remove(id);
        } else {
            System.out.println("Задачи с таким ид нет");
        }
    }

    public void deleteSubtaskById(Integer id){
        if (subtasks.containsKey(id)){
            Subtask subtask = subtasks.get(id);
            subtasks.remove(id);
            changeEpicStatus(subtask.getIdEpic());
        } else {
            System.out.println("Подзадачи с таким ид нет");
        }
    }

    public void deleteEpicById(Integer id){
        ArrayList<Subtask> epicSubtasks = getSubtasksFromEpic(id);
        if (epics.containsKey(id)){
            if (epicSubtasks != null){
                for (Subtask subtask: epicSubtasks){
                    Integer idSubtask = subtask.getId();
                    deleteSubtaskById(idSubtask);
                }
            }
            epics.remove(id);
        } else {
            System.out.println("Эпика с таким ид нет");
        }
    }

    //метод получения списка всех subtasks from epic
    public ArrayList<Subtask> getSubtasksFromEpic(Integer id){
        ArrayList<Subtask> epicSubtasks =new ArrayList<>();
        for (Subtask subtask: subtasks.values()){
            if(subtask.idEpic == id){
                epicSubtasks.add(subtask);
            }
        }
        return epicSubtasks;
    }

    //метод обновления статуса эпика
    public void changeEpicStatus(Integer id){
        ArrayList<TaskStatus> subtasksStatus =new ArrayList<>();
        ArrayList<Subtask> epicSubtasks = getSubtasksFromEpic(id);
        boolean subtaskNew = false;
        boolean subtaskDone = false;
        if (epics.containsKey(id)) {
            //создание списка статусов подзадач эпика
            for (Subtask subtask: epicSubtasks){
                subtasksStatus.add(subtask.getStatus());
            }
            //проверка статусов подзадач
            for (TaskStatus taskStatus: subtasksStatus){
                if (taskStatus.equals(TaskStatus.NEW)){
                    subtaskNew = true;
                } else if (taskStatus.equals(TaskStatus.DONE)){
                    subtaskDone= true;
                    //System.out.println(subtaskDone);
                } else {
                    subtaskDone = false;
                    subtaskNew = false;
                }
            }
            //обновление статусов эпика
            if (epicSubtasks == null || subtaskNew) {
                epics.get(id).setStatus(TaskStatus.NEW);
            } else if (subtaskDone) {
                epics.get(id).setStatus(TaskStatus.DONE);
            } else {
                epics.get(id).setStatus(TaskStatus.IN_PROGRESS);
            }
        } else {
            System.out.println("Такого эпика нет");
        }

    }

    //метод генерации нового ид
    public int generateId(){
        counter++;
        return counter;
    }

}

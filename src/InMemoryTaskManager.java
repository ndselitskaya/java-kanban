import java.util.ArrayList;
import java.util.HashMap;

//класс для работы с задачами
public class InMemoryTaskManager implements TaskManager {
    private int counter = 0; //поле счетчик для ид
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final ArrayList<Task> hisoryTasks= new ArrayList<>();

    //методы создания задач
    @Override
    public void createTask(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
    }

    @Override
    public void createSubtask(Subtask subtask) {
        subtask.setId(generateId());
        subtasks.put(subtask.getId(), subtask);
        changeEpicStatus(subtask.getIdEpic());
    }

    @Override
    public void createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
    }

    //методы получения списка всех задач
    @Override
    public ArrayList<Task> getAllTasks() {
        for (Task task : tasks.values()) {
            System.out.println(task);
        }
        return new ArrayList<>(tasks.values());
    }

    @Override
    public ArrayList<Subtask> getAllSubtasks() {
        for (Subtask subtask : subtasks.values()) {
            System.out.println(subtask);
        }
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public ArrayList<Epic> getAllEpics() {
        for (Epic epic : epics.values()) {
            System.out.println(epic);
        }
        return new ArrayList<>(epics.values());
    }

    //методы удаления всех задач
    @Override
    public void deleteAllTasks() {
        tasks.clear();
    }

    @Override
    public void deleteAllSubtasks() {
        subtasks.clear();
        for(Epic epic: epics.values()){
            Integer idEpic = epic.getId();
            epic.deleteSubtask(idEpic);
            changeEpicStatus(idEpic);
        }
    }

    @Override
    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();
    }

    //методы получения списка задач по id
    @Override
    public Task getTaskById(Integer id) {
        Task task = null;
        if (tasks.containsKey(id)) {
            System.out.println(tasks.get(id));
            task = tasks.get(id);
            addTaskToHistory(task);
        } else {
            System.out.println("Задачи с таким ид нет");
        }
        return task;
    }

    @Override
    public Subtask getSubtaskById(Integer id) {
        Subtask subtask = null;
        if (subtasks.containsKey(id)) {
            System.out.println(subtasks.get(id));
            subtask = subtasks.get(id);
            addTaskToHistory(subtask);
        } else {
            System.out.println("Подзадачи с таким ид нет");
        }
        return subtask;
    }

    @Override
    public Epic getEpicById(Integer id) {
        Epic epic = null;
        if (epics.containsKey(id)) {
            System.out.println(epics.get(id));
            epic = epics.get(id);
            addTaskToHistory(epic);
        } else {
            System.out.println("Эпика с таким ид нет");
        }
        return epic;
    }

    //методы обновления задач
    @Override
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        } else {
            System.out.println("Такой задачи нет");
        }
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
            changeEpicStatus(subtask.getIdEpic());
        } else {
            System.out.println("Такой подзадачи нет");
        }
    }

    @Override
    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
        } else {
            System.out.println("Такого эпика нет");
        }
    }

    //методы удаления задач по ид
    @Override
    public void deleteTaskById(Integer id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            System.out.println("Задачи с таким ид нет");
        }
    }

    @Override
    public void deleteSubtaskById(Integer id) {
        if (subtasks.containsKey(id)) {
            Subtask subtask = subtasks.get(id);
            subtasks.remove(id);
            changeEpicStatus(subtask.getIdEpic());
        } else {
            System.out.println("Подзадачи с таким ид нет");
        }
    }

    @Override
    public void deleteEpicById(Integer id) {
        ArrayList<Subtask> epicSubtasks = getSubtasksFromEpic(id);
        if (epics.containsKey(id)) {
            if (epicSubtasks != null) {
                for (Subtask subtask : epicSubtasks) {
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
    @Override
    public ArrayList<Subtask> getSubtasksFromEpic(Integer id) {
        ArrayList<Subtask> epicSubtasks = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            if(subtask.getIdEpic() == id) {
                epicSubtasks.add(subtask);
            }
        }
        return epicSubtasks;
    }

    //метод обновления статуса эпика
    private void changeEpicStatus(Integer id) {
        ArrayList<TaskStatus> subtasksStatus = new ArrayList<>();
        ArrayList<Subtask> epicSubtasks = getSubtasksFromEpic(id);
        if (subtasks.isEmpty()) {
            epics.get(id).setStatus(TaskStatus.NEW);
            return;
        }
        boolean subtaskNew = false;
        boolean subtaskDone = false;
        if (epics.containsKey(id)) {
            //создание списка статусов подзадач эпика
            for (Subtask subtask : epicSubtasks) {
                subtasksStatus.add(subtask.getStatus());
            }
            //проверка статусов подзадач
            for (TaskStatus taskStatus : subtasksStatus) {
                if (taskStatus.equals(TaskStatus.NEW)) {
                    subtaskNew = true;
                } else if (taskStatus.equals(TaskStatus.DONE)) {
                    subtaskDone = true;
                } else {
                    subtaskDone = false;
                    subtaskNew = false;
                }
            }
            //обновление статусов эпика
            if (subtaskNew) {
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
    private int generateId() {
        counter++;
        return counter;
    }

    //метод добавления просмотренной задачи в кеш
    private void addTaskToHistory(Task task) {
        hisoryTasks.add(task);
        if (hisoryTasks.size()>10){
            hisoryTasks.removeFirst();
        }
    }

    //метод просмотра истории задач
    @Override
    public ArrayList<Task> getHistory(){
        System.out.println(hisoryTasks);
        return hisoryTasks;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
//класс для работы с задачами
public class TaskManager {
    private int counter = 0; //поле счетчик для ид
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

    //методы создания задач
    public void createTask(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
    }

    public void createSubtask(Subtask subtask) {
        subtask.setId(generateId());
        subtasks.put(subtask.getId(), subtask);
        changeEpicStatus(subtask.getIdEpic());
    }

    public void createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
    }

    //методы получения списка всех задач
    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }


    public ArrayList<Subtask> getAllSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public ArrayList<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    //методы удаления всех задач
    public void deleteAllTasks() {
        tasks.clear();
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
        for(Epic epic: epics.values()){
            Integer idEpic = epic.getId();
            epic.deleteSubtask(idEpic);
            changeEpicStatus(idEpic);
        }
    }

    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();
    }

    //методы получения списка задач по id
    public Task getTaskById(Integer id) {
        Task task = null;
        if (tasks.containsKey(id)) {
            System.out.println(tasks.get(id));
            task = tasks.get(id);
        } else {
            System.out.println("Задачи с таким ид нет");
        }
        return task;
    }

    public Subtask getSubtaskById(Integer id) {
        Subtask subtask = null;
        if (subtasks.containsKey(id)) {
            System.out.println(subtasks.get(id));
            subtask = subtasks.get(id);
        } else {
            System.out.println("Подзадачи с таким ид нет");
        }
        return subtask;
    }

    public Epic getEpicById(Integer id) {
        Epic epic = null;
        if (epics.containsKey(id)) {
            System.out.println(epics.get(id));
            epic = epics.get(id);
        } else {
            System.out.println("Эпика с таким ид нет");
        }
        return epic;
    }

    //методы обновления задач
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        } else {
            System.out.println("Такой задачи нет");
        }
    }

    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
            changeEpicStatus(subtask.getIdEpic());
        } else {
            System.out.println("Такой подзадачи нет");
        }
    }

    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
        } else {
            System.out.println("Такого эпика нет");
        }
    }

    //методы удаления задач по ид
    public void deleteTaskById(Integer id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            System.out.println("Задачи с таким ид нет");
        }
    }

    public void deleteSubtaskById(Integer id) {
        if (subtasks.containsKey(id)) {
            Subtask subtask = subtasks.get(id);
            subtasks.remove(id);
            changeEpicStatus(subtask.getIdEpic());
        } else {
            System.out.println("Подзадачи с таким ид нет");
        }
    }

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
    public void changeEpicStatus(Integer id) {
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

}

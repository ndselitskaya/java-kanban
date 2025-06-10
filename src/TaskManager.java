import java.util.List;

public interface TaskManager {
    //методы создания задач
    void createTask(Task task);

    void createSubtask(Subtask subtask);

    void createEpic(Epic epic);

    //методы получения списка всех задач
    List<Task> getAllTasks();

    List<Subtask> getAllSubtasks();

    List<Epic> getAllEpics();

    //методы удаления всех задач
    void deleteAllTasks();

    void deleteAllSubtasks();

    void deleteAllEpics();

    //методы получения списка задач по id
    Task getTaskById(Integer id);

    Subtask getSubtaskById(Integer id);

    Epic getEpicById(Integer id);

    //методы обновления задач
    void updateTask(Task task);

    void updateSubtask(Subtask subtask);

    void updateEpic(Epic epic);

    //методы удаления задач по ид
    void deleteTaskById(Integer id);

    void deleteSubtaskById(Integer id);

    void deleteEpicById(Integer id);

    //метод получения списка всех subtasks from epic
    List<Subtask> getSubtasksFromEpic(Integer id);

    List<Task> getHistory();
}

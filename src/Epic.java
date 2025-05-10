import java.util.ArrayList;

public class Epic extends Task {
    protected ArrayList<Integer> subtasksId;

    public Epic(Integer id, String taskName, String taskDescription, TaskStatus status) {
        super(id, taskName, taskDescription, status);
        this.subtasksId = new ArrayList<>();
    }

    // getter для подзадач
    public ArrayList<Integer> getSubtasks() {
        return subtasksId;
    }

    //добавление подзадачи
    public void addSubtask(int idSubtask) {
        subtasksId.add(idSubtask);
    }

    //удаление подзадачи
    public void deleteSubtask(int idSubtask) {
        subtasksId.remove(Integer.valueOf(idSubtask));
    }

    @Override
    public String toString() {
        String result = "Epic{" +
                "id='" + id + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", subtasksId='" + subtasksId + '\'' +
                ", status=" + status + '}';
        ;
        return result;
    }
}


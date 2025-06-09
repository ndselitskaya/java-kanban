import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subtasksId;

    public Epic(Integer id, String taskName, String taskDescription, TaskStatus status) {
        super(id, taskName, taskDescription, status);
        this.subtasksId = new ArrayList<>();
    }

    // getter для подзадач
    public List<Integer> getSubtasks() {
        return subtasksId;
    }

    //добавление подзадачи
    public void addSubtask(int idSubtask) {
        if (this.getId() == idSubtask) {
            throw new IllegalArgumentException("Эпик не может быть подзадачей самого себя");
        }
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


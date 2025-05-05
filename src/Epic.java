import java.util.ArrayList;

public class Epic extends Task {

    public Epic(Integer id, String taskName, String taskDescription, TaskStatus status) {
        super(id, taskName, taskDescription, status);
    }

    @Override
    public String toString() {
        String result = "Epic{" +
                "id='" + id + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", status=" + status + '}';
        ;
        return result;
    }
}


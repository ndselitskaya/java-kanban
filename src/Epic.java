import java.util.ArrayList;

public class Epic extends Task{

    protected ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(Integer id, String taskName, String taskDescription, ArrayList<Subtask> subtasks , TaskStatus status) {
        super(id, taskName, taskDescription, status);
        this.subtasks=subtasks;
    }

    // getter для подзадач
    public ArrayList<Subtask> getSubtasks(){
        return subtasks;
    }

}

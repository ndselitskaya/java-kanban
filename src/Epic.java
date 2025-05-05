import java.util.ArrayList;

public class Epic extends Task{

    protected ArrayList<Integer> subtasksId = new ArrayList<>();

    public Epic(Integer id, String taskName, String taskDescription, ArrayList<Integer> subtasksId , TaskStatus status){
        super(id, taskName, taskDescription, status);
        this.subtasksId=subtasksId;
    }

    // getter для подзадач
    public ArrayList<Integer> getSubtasks(){
        return subtasksId;
    }

}

public class Subtask extends Task{
    protected int idEpic;

    public Subtask(int idEpic, Integer id, String taskName, String taskDescription, TaskStatus status) {
        super(id, taskName, taskDescription, status);
        this.idEpic=idEpic;
    }

    // getter для эпика
    public int getIdEpic(){
        return idEpic;
    }
}

public class Subtask extends Task{
    private int idEpic;

    public Subtask(int idEpic, Integer id, String taskName, String taskDescription, TaskStatus status) {
        super(id, taskName, taskDescription, status);
        this.idEpic=idEpic;
    }

    // getter для эпика
    public int getIdEpic(){
        return idEpic;
    }

    @Override
    public String toString() {
        String result = "Subtask{" +
                "idEpic='" + idEpic + '\'' +
                ", id='" + id + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", status=" + status + '}';;
        return result;
    }
}

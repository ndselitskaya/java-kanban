import java.util.Objects;

//основной класс задач - родитель
public class Task {
    protected Integer id;
    protected String taskName;
    protected String taskDescription;
    protected TaskStatus status;

    //конструктор класса
    public Task(Integer id, String taskName, String taskDescription, TaskStatus status){
        this.id=id;
        this.taskName=taskName;
        this.taskDescription =taskDescription;
        this.status = status;
    }

    // getter для id
    public Integer getId(){
        return id;
    }
    // setter для id
    public void setId(Integer id){
        this.id=id;
    }

    // getter для статуса
    public TaskStatus getStatus(){
        return status;
    }

    // setter для status
    public void setStatus(TaskStatus status){
        this.status = status;
    }

    // getter для описания
    public String getTaskName() {
        return taskName;
    }

    // getter для описания
    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id;
    }

    @Override
    public int hashCode() {
       return Objects.hash(id);
    }

    @Override
    public String toString() {
        String result = "Task{" +
                "id='" + id + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", status=" + status + '}';;
        return result;
    }
}

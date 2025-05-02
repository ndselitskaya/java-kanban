//основной класс задач - родитель
public class Task {
    protected String taskName;
    protected String taskDescription;
    //надо ли ид????
    protected TaskStatus status;


    //конструктор класса
    public Task( String taskName, String taskDescription, TaskStatus status){
        this.taskName=taskName;
        this.taskDescription =taskDescription;
        this.status = status;
    }

    // метод get для статуса
    public TaskStatus getStatus(){
        return status;
    }

    // метод get для описания
    public String getTaskName() {
        return taskName;
    }

    // метод get для описания
    public String getTaskDescription() {
        return taskDescription;
    }

}

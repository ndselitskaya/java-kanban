import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!"); //убрать
        createTasks();
    }
/*
    public static HashMap<Integer, Task> createTasks() {
        HashMap<Integer, Task> tasks = new HashMap<>();
        tasks.put(1, new Task("ФЗ№4", "Выполнить задание", TaskStatus.NEW));
        tasks.put(2, new Task("Убрать квартиру", "Помыть полы", TaskStatus.NEW));
        //tasks.put(3, new Task("Прочесть учебник по алгоритмам", "Главы 1-4", TaskStatus.IN_PROGRESS));
        //tasks.put(4, new Task("Поставить релиз в ПРОМ", "Установка на блоки сендбокса возмещений", TaskStatus.NEW));
        //tasks.put(5, new Task("Написать инструкцию по мониторингу", "Описать алерты по фин.профилю", TaskStatus.DONE);
        return tasks;
    }

    public static HashMap<Integer, Task> createSubtasks() {
        HashMap<Integer, Task> subtasks = new HashMap<>();
        subtasks.put(1, new Subtask(1, "ФЗ№4", "Выполнить задание", TaskStatus.NEW));
        subtasks.put(2, new Subtask(1, "Убрать квартиру", "Помыть полы", TaskStatus.NEW));
        subtasks.put(3, new Subtask(2, "Прочесть учебник по алгоритмам", "Главы 1-4", TaskStatus.IN_PROGRESS));
        return subtasks;
    }

    public static HashMap<Integer, Task> createEpic() {
        HashMap<Integer, Task> epic = new HashMap<>();
        //надо вставить список подзадач
        epic.put(1, new Epic("ФЗ№4", "Выполнить задание",new ArrayList<>(), TaskStatus.NEW));
        epic.put(2, new Epic("Убрать квартиру", "Помыть полы", new ArrayList<>(), TaskStatus.NEW));
        return epic;
    }
*/
}

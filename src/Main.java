import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        String command = scanner.nextLine();

        switch (command) {
            case "1":

                break;
            case "2":

                break;
            case "3":

                break;
            case "0":
                return;
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Работа с задачами");
        System.out.println("2 - Работа с подзадачами");
        System.out.println("3 - Работа с эпиками");
        System.out.println("0 - Выход");
    }
    /*
    public static void createTasks() {
        tasks.put(1, new Task(1,"ФЗ№4", "Выполнить задание", TaskStatus.NEW));
        tasks.put(2, new Task(2, "Убрать квартиру", "Помыть полы", TaskStatus.NEW));
        //tasks.put(3, new Task("Прочесть учебник по алгоритмам", "Главы 1-4", TaskStatus.IN_PROGRESS));
        //tasks.put(4, new Task("Поставить релиз в ПРОМ", "Установка на блоки сендбокса возмещений", TaskStatus.NEW));
        //tasks.put(5, new Task("Написать инструкцию по мониторингу", "Описать алерты по фин.профилю", TaskStatus.DONE);
     }
/*
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

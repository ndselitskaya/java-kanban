public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        System.out.println("=== Создание задач ===\n");
        Task task1 = manager.createTask(new Task(1, "ФЗ№4", "Выполнить задание", TaskStatus.NEW));
        Task task2 = manager.createTask(new Task(2, "Убрать квартиру", "Помыть полы", TaskStatus.NEW));
        Epic epic1 = manager.createEpic(new Epic(3, "Эпик 1", "Эпик с 1 подзадачей", TaskStatus.IN_PROGRESS));
        Epic epic2 = manager.createEpic(new Epic(4, "Эпик 2", "Эпик с 2-мя подзадачами", TaskStatus.NEW));
        Subtask subtask1 = manager.createSubtask(new Subtask(epic1.getId(), 5, "Подзадача 1", "Описание подзадачи 1", TaskStatus.IN_PROGRESS));
        Subtask subtask2 = manager.createSubtask(new Subtask(epic2.getId(), 6, "Подзадача 2", "Описание подзадачи 2", TaskStatus.IN_PROGRESS));
        Subtask subtask3 = manager.createSubtask(new Subtask(epic2.getId(), 7, "Подзадача 3", "Описание подзадачи 3", TaskStatus.NEW));
        printAllTasks(manager);
        System.out.println();
        System.out.println("=== Изменение статусов задач ===\n");
        task1.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateTask(task1);
        System.out.println("Задача с новым статусом: ");
        manager.getTaskById(task1.getId());
        subtask1.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask1);
        System.out.println("Подзадача с новым статусом: ");
        manager.getSubtaskById(subtask1.getId());
        epic2.setStatus(TaskStatus.NEW);
        manager.updateEpic(epic2);
        System.out.println("Эпики с новыми статусами: ");
        manager.getAllEpics();
        System.out.println();
        System.out.println("=== Удаление задачи по ид ===\n");
        manager.deleteTaskById(task1.getId());
        System.out.println("Задачи после удаления:");
        manager.getAllTasks();
        manager.deleteEpicById(epic1.getId());
        System.out.println("Эпик и подзадачи после удаления:");
        manager.getAllEpics();
        manager.getAllSubtasks();
    }

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        manager.getAllTasks();
        System.out.println("Эпики:");
        manager.getAllEpics();
        System.out.println("Все подзадачи:");
        manager.getAllSubtasks();
    }

}

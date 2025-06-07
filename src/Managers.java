public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}

/*
Утилитарный класс
Со временем в приложении трекера появится несколько реализаций интерфейса TaskManager. Чтобы не зависеть от реализации,
создайте утилитарный класс Managers. На нём будет лежать вся ответственность за создание менеджера задач. То есть
Managers должен сам подбирать нужную реализацию TaskManager и возвращать объект правильного типа.
 --пока непонятно зооочем он
 */
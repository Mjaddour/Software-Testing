package task_service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskService {

    private static List<Task> tasks;

    public TaskService(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static boolean addTask(Task task) {
        int index = getIndex(task);

        if (index < 0 && validateID(task.getId()) && validateName(task.getName()) && validateDescription(task.getDescription())) {
            tasks.add(task);
            return true;
        }

        return false;
    }

    public static boolean deleteTask(String id) {
        Task taskToDelete = new Task(id, "", "");
        int index = getIndex(taskToDelete);

        if (index >= 0) {
            tasks.remove(index);
            return true;
        }

        return false;
    }

    public static void update(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(task)) {
                tasks.set(i, task);
            }
        }
    }

    public static int getIndex(Task task) {
        Comparator<Task> compareById = Comparator.comparing(Task::getId);
        return Collections.binarySearch(tasks, task, compareById);
    }

    public static boolean validateID(String id) {
        return id != null && id.length() <= 10;
    }

    public static boolean validateName(String name) {
        return name != null && name.length() <= 20;
    }

    public static boolean validateDescription(String description) {
        return description != null && description.length() <= 50;
    }
}

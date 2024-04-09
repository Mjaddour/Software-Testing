package task_service;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
public class TaskServiceTest {

    private List<Task> tasks = new ArrayList<>();

    @Test
    public void addNewTaskUsingID() {
        Task task = new Task("1000000001", "Studying", "Study Java Programming");
        addTask(task);
        assertEquals(1, tasks.size());
    }

    @Test
    public void failedAddingExistingID() {
        Task task = new Task("1000000001", "Studying", "Study Java Programming");
        addTask(task);

        Task taskWithSameID = new Task("1000000001", "DifferentName", "DifferentDescription");
        boolean addedSuccessfully = addTask(taskWithSameID);
        assertFalse(addedSuccessfully);
        assertEquals(1, tasks.size());
    }

    @Test
    public void deletingExistingTask() {
        Task task = new Task("10", "Studying", "Study Java Programming");
        addTask(task);
        boolean deletionResult = deleteTask("10");
        assertTrue(deletionResult);
        assertEquals(0, tasks.size());
    }
    @Test
    public void deletingNonExistingTaskfailed() {
        Task task = new Task("10", "Studying", "Study Java Programming");
        addTask(task);
        boolean deletionResult = deleteTask("11");
        assertFalse(deletionResult);
        assertEquals(1, tasks.size());
    }

    @Test
    public void updateTask() {
        Task taskoriginal = new Task("1009706401", "Coding", "Java Coding Practice");
        addTask(taskoriginal);
        Task taskupdated = new Task("1009706401","Homework","C++");
        update(taskupdated);
        
        Task fetchedTask = getTaskById("1009706401");
        assertEquals("Homework",fetchedTask.getName());
        assertEquals("C++",fetchedTask.getDescription());
        assertEquals(1,tasks.size());
    }
    @Test
    public void updateNonExistingTaskFailed() {
        Task taskOriginal = new Task("1009706401", "Coding", "Java Coding Practice");
        addTask(taskOriginal);

        Task taskUpdated = new Task("10097064", "Homework", "C++");
        boolean updateResult = update(taskUpdated);
        assertFalse("Update should fail for non-existing task", updateResult);
        Task fetchedTask = getTaskById("10097064");
        assertNull("Task should be null", fetchedTask);
        assertEquals(1, tasks.size());
    }


    public boolean addTask(Task task) {
        int index = getIndex(task);

        if (index < 0) {
            tasks.add(task);
            return true;
        }

        return false;
    }

    public boolean deleteTask(String id) {
        Task taskToDelete = new Task(id, "", "");
        int index = getIndex(taskToDelete);

        if (index >= 0) {
            tasks.remove(index);
            return true;
        }

        return false;
    }

    public boolean update(Task task) {
        int index = tasks.indexOf(task);

        if (index >= 0 && validateName(task.getName()) && validateDescription(task.getDescription())) {
            tasks.set(index, task);
            return true;
        }

        return false;
    }


    public int getIndex(Task task) {
        return Collections.binarySearch(tasks, task, Task.compareById);
    }

    public static boolean validateName(String name) {
        return name != null && name.length() <= 20;
    }

    public boolean validateDescription(String description) {
        return description != null && description.length() <= 50;
    }
    public Task getTaskById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}

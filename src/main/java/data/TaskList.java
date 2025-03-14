package data;

import data.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of tasks.
 */
public class TaskList {

    private final List<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with an existing list of tasks.
     * @param tasks List of tasks.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Adds a new task to the list.
     * @param toAdd Task to add.
     */
    public void addTask(Task toAdd) {
        tasks.add(toAdd);
    }

    /**
     * Removes a task at a specific index.
     * @param taskIndex Index of the task to remove.
     */
    public void deleteTask(int taskIndex) {
        tasks.remove(taskIndex);
    }

    /**
     * Gets all tasks in the list.
     * @return List of tasks.
     */
    public List<Task> getAllTasks() {
        return this.tasks;
    }

    /**
     * Finds tasks that contain a specific keyword.
     * @param keyword The search keyword.
     * @return List of matching tasks.
     */
    public List<Task> findMatch(String keyword) {
        List<Task> internalList = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTaskName().toLowerCase().contains(keyword)) {
                internalList.add(task);
            }
        }
        return internalList;
    }
}

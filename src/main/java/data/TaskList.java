package data;

import data.task.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskList {

    private final List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

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

    public void addTask(Task toAdd) {
        tasks.add(toAdd);
    }

    public void deleteTask(int taskIndex) {
        tasks.remove(taskIndex);
    }

    public List<Task> getAllTasks() {
        return this.tasks;
    }
}

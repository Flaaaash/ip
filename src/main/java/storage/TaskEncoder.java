package storage;

import data.TaskList;

import java.util.ArrayList;
import java.util.List;

public class TaskEncoder {
    public static List<String> encodeTaskList(TaskList toSave) {
        final List<String> encodedTasks = new ArrayList<>();
        toSave.getAllTasks().forEach(task -> encodedTasks.add(task.toFileString()));
        return encodedTasks;
    }
}

package storage;

import data.TaskList;

import java.util.ArrayList;
import java.util.List;

/**
 * Encodes the {@code TaskList} object into a data file for storage.
 */
public class TaskEncoder {
    /**
     * Encodes all the {@code Task} in the {@code toSave} into a list of decodable and readable string presentation
     * for storage.
     */
    public static List<String> encodeTaskList(TaskList toSave) {
        final List<String> encodedTasks = new ArrayList<>();
        toSave.getAllTasks().forEach(task -> encodedTasks.add(task.toFileString()));
        return encodedTasks;
    }
}

package storage;

import data.TaskList;
import data.task.Deadline;
import data.task.Event;
import data.task.Task;
import data.task.Todo;
import exceptions.IllegalValueException;
import storage.StorageFile.StorageOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Decodes the storage data file into an {@code TaskList} object.
 */
public class TaskDecoder {

    public static final Pattern TODO_DATA_FORMAT = Pattern.compile("T / [01] / .+");

    /**
     * Decodes {@code encodedTaskList} into an {@code TaskList} containing the decoded tasks.
     *
     * @throws StorageOperationException if the {@code encodedTaskList} is in an invalid format.
     */
    public static TaskList decodeTaskList(List<String> encodedTasks)
            throws StorageOperationException {
        final List<Task> decodedTasks = new ArrayList<>();
        for (String encodedTask : encodedTasks) {
            decodedTasks.add(decodeTaskFromString(encodedTask));
        }
        return new TaskList(decodedTasks);
    }

    /**
     * Decodes {@code encodedTask} into a {@code Task}.
     *
     * @throws StorageOperationException if {@code encodedTask} is in an invalid format.
     */
    private static Task decodeTaskFromString(String encodedTask)
            throws StorageOperationException {
        String[] encodedParts = encodedTask.split(" / ");
        try {
            String type = encodedParts[0];
            boolean isDone = encodedParts[1].equals("1");
            String description = encodedParts[2];

            switch (type) {
            case "T":
                Todo todo = new Todo(description);
                if (isDone) {
                    todo.markAsDone();
                }
                return todo;

            case "D":
                Deadline deadline = new Deadline(description, encodedParts[3]);
                if (isDone) {
                    deadline.markAsDone();
                }
                return deadline;

            case "E":
                Event event = new Event(description, encodedParts[3], encodedParts[4]);
                if (isDone) {
                    event.markAsDone();
                }
                return event;

            default:
                throw new IllegalValueException("Invalid task type");
            }
        } catch (Exception e) {
            throw new StorageOperationException("Encoded task in invalid format. Unable to decode.");
        }
    }
}


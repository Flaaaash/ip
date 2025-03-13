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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskDecoder {

    public static final Pattern TODO_DATA_FORMAT = Pattern.compile("T / [01] / .+");

    public static TaskList decodeTaskList(List<String> encodedTasks)
            throws IllegalValueException, StorageOperationException {
        final List<Task> decodedTasks = new ArrayList<>();
        for (String encodedTask : encodedTasks) {
            decodedTasks.add(decodeTaskFromString(encodedTask));
        }
        return new TaskList(decodedTasks);
    }

    private static Task decodeTaskFromString(String encodedTask)
            throws IllegalValueException, StorageOperationException {
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


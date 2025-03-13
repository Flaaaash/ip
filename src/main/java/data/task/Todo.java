package data.task;

/**
 * Represents a Todo task without any specific date or time.
 */
public class Todo extends Task {
    public Todo(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileString() {
        return "T / " + (isDone ? "1" : "0") + " / " + taskName;
    }
}

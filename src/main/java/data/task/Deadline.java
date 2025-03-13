package data.task;

/**
 * Represents a Deadline task with a due time.
 */
public class Deadline extends Task {
    protected String deadline;

    /**
     * Constructs a Deadline task with a task name and deadline.
     * @param taskName Name of the deadline task.
     * @param deadline Due time of the task.
     */
    public Deadline(String taskName, String deadline) {
        super(taskName);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }

    @Override
    public String toFileString() {
        return "D / " + (isDone ? "1" : "0") + " / " + taskName + " / " + deadline;
    }
}

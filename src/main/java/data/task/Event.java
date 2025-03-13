package data.task;

/**
 * Represents an Event task with a start and end time.
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Constructs an Event task with a task name, start time, and end time.
     * @param taskName Name of the event task.
     * @param from Start time of the event.
     * @param to End time of the event.
     */
    public Event(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toFileString() {
        return "E / " + (isDone ? "1" : "0") + " / " + taskName + " / " + from + " / " + to;
    }
}

package data.task;

/**
 * Represents a task with a name and completion status.
 */
public abstract class Task {
    protected String taskName;
    protected boolean isDone;

    /**
     * Constructs a new Task with the given task name.
     * @param taskName Name of the task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    /**
     * Gets the status icon representing whether the task is done.
     * @return "X" if done, otherwise a space " ".
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + taskName;
    }

    /**
     * Returns the task formatted as a string for file storage.
     * @return String representation for file storage.
     */
    public abstract String toFileString();
}

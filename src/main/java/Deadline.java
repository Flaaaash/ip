public class Deadline extends Task {
    protected String deadline;

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

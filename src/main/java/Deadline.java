public class Deadline extends Task {
    protected String deadLine;

    public Deadline(String taskName, String deadLine) {
        super(taskName);
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadLine + ")";
    }
}

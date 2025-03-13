package commands;

/**
 * Mark the task specified by the user as done.
 */
public class MarkCommand extends Command {

    public static final String COMMAND_WORD = "mark";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Mark the task with target index number as done.\n"
            + " -Example: " + COMMAND_WORD
            + " 1";

    public int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute() {
        if (taskIndex < 1 || taskIndex > taskList.size()) {
            return String.format("Index %d is invalid", taskIndex);
        }
        taskList.get(taskIndex - 1).markAsDone();
        return "Nice! I've marked this task as done:" + "\n" + "  " + taskList.get(taskIndex - 1);
    }
}

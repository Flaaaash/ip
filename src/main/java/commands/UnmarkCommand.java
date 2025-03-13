package commands;

/**
 * Mark the task specified by the user as undone.
 */
public class UnmarkCommand extends Command {

    public static final String COMMAND_WORD = "unmark";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Mark the task with target index number as undone.\n"
            + " -Example: " + COMMAND_WORD
            + " 1";


    public int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute() {
        if (taskIndex < 1 || taskIndex > taskList.size()) {
            return String.format("Index %d is invalid", taskIndex);
        }
        taskList.get(taskIndex - 1).unmarkAsDone();
        return "OK, I've marked this task as not done yet:" + "\n" + "  " + taskList.get(taskIndex - 1);
    }
}
package commands;

public class UnmarkCommand extends Command {

    public static final String COMMAND_WORD = "unmark";

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
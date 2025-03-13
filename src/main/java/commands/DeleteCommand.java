package commands;

public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    private final int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    public String execute() {
        if (taskIndex < 1 || taskIndex > taskList.size()) {
            return String.format("Index %d is invalid", taskIndex);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Noted. I've removed this tasks:").append("\n")
                .append("  ").append(taskList.get(taskIndex - 1).toString()).append("\n");
        taskList.deleteTask(taskIndex - 1);
        sb.append("Now you have ").append(taskList.size()).append(" tasks in the list.");
        return sb.toString();
    }
}

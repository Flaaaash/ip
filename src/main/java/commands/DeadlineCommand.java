package commands;

import data.task.Deadline;


public class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a deadline task to the task list.\n"
            + "Parameters: TASK_NAME /by DEADLINE\n"
            + " -Example: " + COMMAND_WORD
            + " Return a book /by Saturday";

    private final Deadline deadline;

    public DeadlineCommand(String taskName, String deadline) {
        this.deadline = new Deadline(taskName, deadline);
    }

    public String execute() {
        taskList.addTask(deadline);
        StringBuilder sb = new StringBuilder();
        sb.append("Got it. I've added this task:").append("\n");
        sb.append("  ").append(deadline.toString()).append("\n");
        sb.append("Now you have ").append(taskList.size()).append(" tasks in the list.");
        return sb.toString();
    }
}

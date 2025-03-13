package commands;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all tasks as a list with index numbers.";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public String execute() {
        if (taskList.isEmpty()) {
            return "You don't have any task yet.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in your list:").append("\n");
        int size = taskList.size();
        for (int i = 0; i < size - DISPLAYED_INDEX_OFFSET; i += 1) {
            sb.append((i + DISPLAYED_INDEX_OFFSET)).append(". ").append(taskList.get(i).toString()).append("\n");
        }
        sb.append(size).append(". ").append(taskList.get(size - 1).toString());
        return sb.toString();
    }
}

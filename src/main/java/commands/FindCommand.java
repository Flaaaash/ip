package commands;

import data.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds and lists all tasks in task list of which the name contains the argument keyword(s).
 * Keyword matching is case-sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all tasks as a list with target key word(s)."
            + " -Example: " + COMMAND_WORD
            + " read";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public String execute() {
        List<Task> matchingTasks = taskList.findMatch(keyword);

        if (matchingTasks.isEmpty()) {
            return "You don't have any matching task in your list.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list:").append("\n");
        int size = matchingTasks.size();
        for (int i = 0; i < size - DISPLAYED_INDEX_OFFSET; i += 1) {
            sb.append((i + DISPLAYED_INDEX_OFFSET)).append(". ").append(matchingTasks.get(i).toString()).append("\n");
        }
        sb.append(size).append(". ").append(matchingTasks.get(size - 1).toString());
        return sb.toString();
    }
}

package commands;

import data.task.Todo;

/**
 * Adds a todo task to the task list.
 */
public class TodoCommand extends Command {

    public static final String COMMAND_WORD = "todo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a todo task to the task list.\n"
                    + " -Example: " + COMMAND_WORD
                    + " Read a book";

    private final Todo todo;

    public TodoCommand(String taskName) {
        this.todo = new Todo(taskName);
    }

    public String execute() {
        taskList.addTask(todo);
        StringBuilder sb = new StringBuilder();
        sb.append("Got it. I've added this task:").append("\n");
        sb.append("  ").append(todo.toString()).append("\n");
        sb.append("Now you have ").append(taskList.size()).append(" tasks in the list.");
        return sb.toString();
    }
}

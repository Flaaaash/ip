package commands;

import data.task.Event;

public class EventCommand extends Command {

    public static final String COMMAND_WORD = "event";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a event task to the task list.\n"
            + "Parameters: TASK_NAME /from EVENT_START_TIME /to EVENT_END_TIME\n"
            + " -Example: " + COMMAND_WORD
            + " Final exam /from 29 April 2025 2:00pm /to 4:00pm";

    private final Event event;

    public EventCommand(String taskName, String from, String to) {
        this.event = new Event(taskName, from, to);
    }

    public String execute() {
        taskList.addTask(event);
        StringBuilder sb = new StringBuilder();
        sb.append("Got it. I've added this task:").append("\n");
        sb.append("  ").append(event.toString()).append("\n");
        sb.append("Now you have ").append(taskList.size()).append(" tasks in the list.");
        return sb.toString();
    }
}

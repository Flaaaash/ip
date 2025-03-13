package commands;

import data.TaskList;

public class Command {
    protected TaskList taskList;

    /**
     * Executes the command and returns the result.
     */
    public String execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    };

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

}

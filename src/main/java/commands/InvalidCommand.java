package commands;

public class InvalidCommand extends Command {

    private final String invalidCommand;

    public static final String MESSAGE_INVALID_COMMAND = "<%1$s> is an unknown command. Please enter <help> for the list of commands.";

    public InvalidCommand(String invalidCommand) {
        this.invalidCommand = invalidCommand;
    }

    public String execute() {
        return String.format(MESSAGE_INVALID_COMMAND, invalidCommand);
    }
}

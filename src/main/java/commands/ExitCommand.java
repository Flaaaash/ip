package commands;

public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT = "Exiting program as requested ...";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.";

    @Override
    public String execute() {
        return MESSAGE_EXIT;
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}

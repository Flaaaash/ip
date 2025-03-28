package commands;

/**
 * Shows help instructions.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.";

    @Override
    public String execute() {
        return ExitCommand.MESSAGE_USAGE
                + "\n" + HelpCommand.MESSAGE_USAGE
                + "\n" + ExitCommand.MESSAGE_USAGE
                + "\n" + ListCommand.MESSAGE_USAGE
                + "\n" + TodoCommand.MESSAGE_USAGE
                + "\n" + DeadlineCommand.MESSAGE_USAGE
                + "\n" + EventCommand.MESSAGE_USAGE
                + "\n" + FindCommand.MESSAGE_USAGE
                + "\n" + MarkCommand.MESSAGE_USAGE
                + "\n" + UnmarkCommand.MESSAGE_USAGE
                + "\n" + DeleteCommand.MESSAGE_USAGE;
    }

}

package commands;

/**
 * Represents a command with wrong format. Upon execution, produces some feedback to the user.
 */
public class WrongFormatCommand extends Command {

    private final String feedbackToUSer;

    public WrongFormatCommand(String feedbackToUser) {
        this.feedbackToUSer = feedbackToUser;
    }

    @Override
    public String execute() {
        return feedbackToUSer;
    }
}

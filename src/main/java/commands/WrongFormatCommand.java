package commands;

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

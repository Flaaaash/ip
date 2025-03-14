import commands.Command;
import commands.ExitCommand;
import data.TaskList;
import parser.Parser;
import storage.StorageFile;
import storage.StorageFile.StorageOperationException;
import ui.TextUi;

/**
 * Entry point of the Flaaaash chatbot application.
 * Initialises the application and starts the interaction with the user.
 */
public class Flaaaash {

    /** Version info of the program. */
    public final String VERSION = "Chatbot Flaaaash Version-0.2";

    private TextUi ui;
    private TaskList taskList;
    private StorageFile storage;

    public static void main(String[] args) { new Flaaaash().run(); }

    /** Runs the program until termination.  */
    public void run() {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    /**
     * Sets up the required objects, loads up the data from the storage file, and prints the welcome message.
     */
    public void start() {
        try {
            this.ui = new TextUi();
            this.storage = new StorageFile();
            this.taskList = storage.load();
            ui.showWelcomeMessage(VERSION);
        } catch (StorageOperationException e) {
            ui.showInitFailedMessage();
            throw new RuntimeException(e);
        }
    }

    /** Reads the user command and executes it, until the user issues the exit command.  */
    public void runCommandLoopUntilExitCommand() {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = new Parser().parseCommand(userCommandText);
            String result = executeCommand(command);
            ui.showToUser(result);
        } while (!ExitCommand.isExit(command));
    }

    /** Prints the Goodbye message and terminates the program. */
    private void exit() {
        ui.showGoodbyeMessage();
        System.exit(0);
    }

    /**
     * Executes the command and returns the result.
     *
     * @param command user command
     * @return result string of the command
     */
    public String executeCommand(Command command) {
        try {
            command.setTaskList(taskList);
            String result = command.execute();
            storage.save(taskList);
            return result;
        } catch (Exception e) {
            ui.showToUser(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}





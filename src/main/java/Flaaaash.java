import commands.Command;
import commands.ExitCommand;
import data.TaskList;
import parser.Parser;
import storage.StorageFile;
import storage.StorageFile.StorageOperationException;
import ui.TextUi;


import java.io.File;


public class Flaaaash {

    public final String VERSION = "Chatbot Flaaaash Version-2.0";

    private TextUi ui;
    private TaskList taskList;
    private StorageFile storage;

    public static void main(String[] args) { new Flaaaash().run(); }

    public void run() {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

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

    public void runCommandLoopUntilExitCommand() {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = new Parser().parseCommand(userCommandText);
            String result = executeCommand(command);
            ui.showToUser(result);
        } while (!ExitCommand.isExit(command));
    }

    private void exit() {
        ui.showGoodbyeMessage();
        System.exit(0);
    }

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





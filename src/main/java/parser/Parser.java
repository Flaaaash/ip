package parser;

import commands.Command;
import commands.DeadlineCommand;
import commands.DeleteCommand;
import commands.EventCommand;
import commands.ExitCommand;
import commands.HelpCommand;
import commands.InvalidCommand;
import commands.ListCommand;
import commands.MarkCommand;
import commands.TodoCommand;
import commands.UnmarkCommand;
import commands.WrongFormatCommand;


public class Parser {

    public Command parseCommand(String userInput) {
        String[] inputParts = userInput.split(" ", 2);
        String commandWord = inputParts[0].toLowerCase();

        switch (commandWord) {

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case TodoCommand.COMMAND_WORD:
            try {
                return new TodoCommand(inputParts[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new WrongFormatCommand("Task description cannot be empty.");
            }

        case DeadlineCommand.COMMAND_WORD:
            try {
                String[] deadlineInputDetails = inputParts[1].split(" /by ", 2);
                String taskName = deadlineInputDetails[0];
                String deadline = deadlineInputDetails[1];
                return new DeadlineCommand(taskName, deadline);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new WrongFormatCommand("Invalid format! " +
                        "Use: deadline <description> /by <due_time>");
            }

        case EventCommand.COMMAND_WORD:
            try {
                String[] eventInputDetails = inputParts[1].split(" /from | /to ", 3);
                String taskName = eventInputDetails[0];
                String from = eventInputDetails[1];
                String to = eventInputDetails[2];
                return new EventCommand(taskName, from, to);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new WrongFormatCommand("Invalid format! " +
                        "Use: event <description> /from <start_time> /to <end_time>");
            }

        case MarkCommand.COMMAND_WORD:
            try {
                int taskIndex = Integer.parseInt(inputParts[1]);
                return new MarkCommand(taskIndex);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new WrongFormatCommand("Invalid format! Use: mark <Task index>");
            }

        case UnmarkCommand.COMMAND_WORD:
            try {
                int taskIndex = Integer.parseInt(inputParts[1]);
                return new UnmarkCommand(taskIndex);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new WrongFormatCommand("Invalid format! Use: unmark <Task index>");
            }

        case DeleteCommand.COMMAND_WORD:
            try {
                int taskIndex = Integer.parseInt(inputParts[1]);
                return new DeleteCommand(taskIndex);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new WrongFormatCommand("Invalid format! Use: delete <Task index>");
            }

        default:
            return new InvalidCommand(commandWord);
        }

    }
}

package parser;

import commands.Command;
import commands.DeadlineCommand;
import commands.DeleteCommand;
import commands.EventCommand;
import commands.ExitCommand;
import commands.FindCommand;
import commands.HelpCommand;
import commands.InvalidCommand;
import commands.ListCommand;
import commands.MarkCommand;
import commands.TodoCommand;
import commands.UnmarkCommand;
import commands.WrongFormatCommand;

/**
 * Parses user input.
 */
public class Parser {

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     */
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
            return prepareAddTodo(inputParts[1]);

        case DeadlineCommand.COMMAND_WORD:
            return prepareAddDeadline(inputParts[1]);

        case EventCommand.COMMAND_WORD:
            return prepareAddEvent(inputParts[1]);

        case FindCommand.COMMAND_WORD:
            return prepareFind(inputParts[1]);

        case MarkCommand.COMMAND_WORD:
            return prepareMark(inputParts[1]);

        case UnmarkCommand.COMMAND_WORD:
            return prepareUnmark(inputParts[1]);

        case DeleteCommand.COMMAND_WORD:
            return prepareDelete(inputParts[1]);

        default:
            return new InvalidCommand(commandWord);
        }

    }

    /**
     * Parses arguments in the context of the todo command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    public Command prepareAddTodo(String args) {
        try {
            return new TodoCommand(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new WrongFormatCommand("Task description cannot be empty.");
        }
    }

    /**
     * Parses arguments in the context of the deadline command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    public Command prepareAddDeadline(String args) {
        try {
            String[] deadlineInputDetails = args.split(" /by ", 2);
            String taskName = deadlineInputDetails[0];
            String deadline = deadlineInputDetails[1];
            return new DeadlineCommand(taskName, deadline);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new WrongFormatCommand("Invalid format! " +
                    "Use: deadline <description> /by <due_time>");
        }
    }

    /**
     * Parses arguments in the context of the event command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    public Command prepareAddEvent(String args) {
        try {
            String[] eventInputDetails = args.split(" /from | /to ", 3);
            String taskName = eventInputDetails[0];
            String from = eventInputDetails[1];
            String to = eventInputDetails[2];
            return new EventCommand(taskName, from, to);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new WrongFormatCommand("Invalid format! " +
                    "Use: event <description> /from <start_time> /to <end_time>");
        }
    }

    /**
     * Parses arguments in the context of the find command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    public Command prepareFind(String args) {
        try {
            String keyword = args.trim().toLowerCase();
            return new FindCommand(keyword);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new WrongFormatCommand("Invalid format! Use: Find <keyword>");
        }
    }

    /**
     * Parses arguments in the context of the mark command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    public Command prepareMark(String args) {
        try {
            int taskIndex = Integer.parseInt(args);
            return new MarkCommand(taskIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new WrongFormatCommand("Invalid format! Use: mark <Task index>");
        }
    }

    /**
     * Parses arguments in the context of the unmark command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    public Command prepareUnmark(String args) {
        try {
            int taskIndex = Integer.parseInt(args);
            return new UnmarkCommand(taskIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new WrongFormatCommand("Invalid format! Use: unmark <Task index>");
        }
    }

    /**
     * Parses arguments in the context of the delete command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    public Command prepareDelete(String args) {
        try {
            int taskIndex = Integer.parseInt(args);
            return new DeleteCommand(taskIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new WrongFormatCommand("Invalid format! Use: delete <Task index>");
        }
    }

}

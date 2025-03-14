# Flaaaash User Guide

Flaaaash is a simple command-line task management application 
that helps users keep track of their tasks efficiently. 
Users can create tasks, mark them as done, delete them, 
and list all tasks. The application also supports saving and 
loading tasks from a file to persist data between sessions.

--------------------------------------------------------------

## Quick Start

1. Ensure you have Java 17 or above installed in your Computer.\
   Mac users: Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest .jar file from [here](https://github.com/Flaaaash/ip/releases).

3. Copy the file to the folder you want to use as the home folder for your Flaaaash chatbot.

4. Open a command terminal, cd into the folder you put the jar file in, and use the java -jar Flaaaash.jar command to run the application.

5. Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
Some example commands you can try:

   - `list` : Lists all tasks.

   - `todo Read a book`: Adds a todo task named Read a book to the task list.

   - `delete 1` : Deletes the 1st task shown in the current list.

   - `exit` : Exits the app.

6. Refer to the Features below for details of each command.

--------------------------------------------------------------------------

## Features


Notes about the command format:
 - Words in `UPPER_CASE` are the parameters to be supplied by the user.\
   e.g. in `todo TASK_NAME`, `TASK_NAME` is a parameter which can be used as `todo Read a Book`.
 - Parameters have a fixed order.
   e.g. if the command specifies `/from START_TIME /to END_TIME`, no other order of input is acceptable.
 - Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, and `exit`) will be ignored.
   e.g. if the command specifies `help 123`, it will be interpreted as `help`.

### Viewing help : `help`
Shows a message explaining all available commands.\
Format: `help`

### Terminating the program : `exit`
Exit the program.\
Format: `exit`

### Adding a todo task: `todo`
Adds a task with no specified time constraints to the task list.\
Format: `todo TASK_NAME`\
Example:
- `todo Read a book`
- `todo Exercise`

### Adding a deadline task: `deadline`
Adds a task with a deadline to the task list.\
Format: `deadline TASK_NAME /by DEADLINE`\
Example:
- `deadline Return the book /by this Saturday`
- `deadline Finish math homework /by tomorrow`

### Adding a event task: `event`
Adds a task with a specified start time and end time to the task list.\
Format: `event TASK_NAME /from START_TIME /to END_TIME`\
Example:
- `event Attend book fair /from 24th April 2025 2pm /to 4pm `

### Listing all tasks : `list`
Shows a list of all tasks in the task list.\
Format: `list`

### Finding tasks with specified keyword(s): `find`
Finds tasks of which contents contain the given keywords.\
Format: `find KEYWORD`
- The search is case-insensitive. e.g read will match Read.
- The order of the keywords **MATTERS**.
- Only the task name is searched.

### Deleting a task : delete
Deletes the specified task from the task list.\
Format: `delete INDEX`

- Deletes the task at the specified INDEX.
- The index refers to the index number shown in the task list (not applicable to the find list).
- The index must be a positive integer.

Examples:
- `delete 2` deletes the 2nd task in the task list.

### Marking a task as done : `mark`
Mark a task as done.\
Format: `mark INDEX`

- Marks the task at the specified INDEX.
- The index refers to the index number shown in the task list (not applicable to the find list).
- The index must be a positive integer.

### Marking a task as undone : `unmark`
Mark a task as undone.\
Format: `unmark INDEX`

- Unmarks the task at the specified INDEX.
- The index refers to the index number shown in the task list (not applicable to the find list).
- The index must be a positive integer.

## Saving the data
Task List data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.
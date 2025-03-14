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

2. Download the latest .jar file from [here](google.com).

3. Copy the file to the folder you want to use as the home folder for your Flaaaash chatbot.

4. Open a command terminal, cd into the folder you put the jar file in, and use the java -jar Flaaaash.jar command to run the application.

5. Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
Some example commands you can try:

   - `list` : Lists all tasks.

   - `todo Read a book`: Adds a todo task named Read a book to the task list.

   - `delete 1` : Deletes the 1st task shown in the current list.

   - `exit` : Exits the app.

6. Refer to the Features below for details of each command.


## Features


Notes about the command format:
 - Words in `UPPER_CASE` are the parameters to be supplied by the user.\
   e.g. in `todo TASK_NAME`, `TASK_NAME` is a parameter which can be used as `todo Read a Book`.
 - Parameters have a fixed order.
   e.g. if the command specifies `/from START_TIME /to END_TIME`, no other order of input is acceptable.

## Feature XYZ

// Feature details


// A description of the expected outcome goes here

```
expected output
```
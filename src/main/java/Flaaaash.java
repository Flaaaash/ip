import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Flaaaash {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final String FILE_PATH = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Flaaaash.txt";

    private static void saveToFile() {
        try {
            File file = new File(FILE_PATH);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" / ");

                try {
                    String type = parts[0];
                    boolean isDone = parts[1].equals("1");
                    String description = parts[2];

                    switch (type) {
                    case "T":
                        Todo todo = new Todo(description);
                        addTaskNoText(todo);
                        if (isDone) {
                            todo.markAsDone();
                        }
                        break;
                    case "D":
                        Deadline deadline = new Deadline(description, parts[3]);
                        addTaskNoText(deadline);
                        if (isDone) {
                            deadline.markAsDone();
                        }
                        break;
                    case "E":
                        Event event = new Event(description, parts[3], parts[4]);
                        addTaskNoText(event);
                        if (isDone) {
                            event.markAsDone();
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid task type");
                    }

                } catch (Exception e) {
                    System.out.println("Skipping corrupted entry: " + line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, starting fresh.");
        }
    }

    private static void markTask(int index) {
        System.out.println("____________________________________________________________");
        if (index < 0 || index > tasks.size()) {
            System.out.println(" Invalid index");
        } else {
            System.out.println(" Nice! I've marked this task as done:");
            tasks.get(index - 1).markAsDone();
            System.out.println("    " + tasks.get(index - 1));
        }
        System.out.println("____________________________________________________________");
    }

    private static void unmarkTask(int index) {
        System.out.println("____________________________________________________________");
        if (index < 0 || index > tasks.size()) {
            System.out.println(" Invalid index");
        } else {
            System.out.println(" OK, I've marked this task as not done yet:");
            tasks.get(index - 1).unmarkAsDone();
            System.out.println("    " + tasks.get(index - 1));
        }
        System.out.println("____________________________________________________________");
    }

    private static void addTask(Task task) {
        tasks.add(task);

        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("    " + task);
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void deleteTask(int index) {
        System.out.println("____________________________________________________________");
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + tasks.get(index - 1));
        tasks.remove(tasks.get(index - 1));
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void addTaskNoText(Task task) {
        tasks.add(task);
    }

    private static void list() {
        System.out.println("____________________________________________________________");
        if (tasks.isEmpty()) {
            System.out.println(" List is empty!");
        } else {
            System.out.println(" Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i += 1) {
                System.out.println(" " + (i + 1) + ". " + tasks.get(i));
            }
            System.out.println("____________________________________________________________");
        }
    }

    private static void repeat(String input) {
        System.out.println("____________________________________________________________");
        System.out.println(" " + input);
        System.out.println("____________________________________________________________");
    }

    private static void reportUnknownCommand(String input) {
        System.out.println("____________________________________________________________");
        System.out.println(" <" + input + "> is an unknown command. Please Refer to the user guide.");
        System.out.println("____________________________________________________________");
    }

    private static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Flaaaash");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    private static void exit() {
        saveToFile();
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        loadFromFile();
        greet();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine().trim();
            String[] inputParts = input.split(" ", 2);
            String command = inputParts[0].toLowerCase();

            switch (command) {
            case "bye":
                exit();
                scanner.close();
                return;

            case "list":
                list();
                break;

            case "mark":
                try {
                    markTask(Integer.parseInt(inputParts[1]));
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid format! Use: mark <Task index>");
                }
                break;

            case "unmark":
                try {
                    unmarkTask(Integer.parseInt(inputParts[1]));
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid format! Use: unmark <Task index>");
                }
                break;

            case "delete":
                try {
                    deleteTask(Integer.parseInt(inputParts[1]));
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid format! Use: delete <Task index>");
                }
                break;

            case "todo":
                if (inputParts.length < 2) {
                    System.out.println("Task description cannot be empty.");
                } else {
                    addTask(new Todo(inputParts[1]));
                }
                break;

            case "deadline":
                try {
                    String[] deadlineInputDetails = inputParts[1].split(" /by ", 2);
                    String deadlineName = deadlineInputDetails[0];
                    String deadLine = deadlineInputDetails[1];
                    addTask(new Deadline(deadlineName, deadLine));
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid format! Use: deadline <description> /by <due_date>");
                }
                break;


            case "event":
                try {
                    String[] eventInputDetails = inputParts[1].split(" /from | /to ", 3);
                    String eventName = eventInputDetails[0];
                    String from = eventInputDetails[1];
                    String to = eventInputDetails[2];
                    addTask(new Event(eventName, from, to));
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid format! Use: event <description> /from <start_time> /to <end_time>");
                }
                break;

            default:
                reportUnknownCommand(command);
            }
        }
    }
}





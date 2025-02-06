import java.util.Scanner;

public class Flaaaash {
    private static final int maxCount = 100;
    private static final Task[] tasks = new Task[maxCount];
    private static int taskCount = 0;

    private static void markTask(int index) {
        System.out.println("____________________________________________________________");
        if (index < 0 || index > taskCount) {
            System.out.println(" Invalid index");
        } else {
            System.out.println(" Nice! I've marked this task as done:");
            tasks[index - 1].markAsDone();
            System.out.println("    " + tasks[index - 1]);
        }
        System.out.println("____________________________________________________________");
    }

    private static void unmarkTask(int index) {
        System.out.println("____________________________________________________________");
        if (index < 0 || index > taskCount) {
            System.out.println(" Invalid index");
        } else {
            System.out.println(" OK, I've marked this task as not done yet:");
            tasks[index - 1].unmarkAsDone();
            System.out.println("    " + tasks[index - 1]);
        }
        System.out.println("____________________________________________________________");
    }

    private static void addTask(Task task) {
        tasks[taskCount] = task;
        taskCount += 1;

        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("    " + tasks[taskCount - 1]);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void list() {
        System.out.println("____________________________________________________________");
        if (taskCount == 0) {
            System.out.println(" List is empty!");
        } else {
            System.out.println(" Here are the tasks in your list:");
            for(int i = 0; i < taskCount; i += 1) {
                System.out.println(" " + (i + 1) + ". " + tasks[i]);
            }
        }
        System.out.println("____________________________________________________________");
    }

    private static void repeat(String input) {
        System.out.println("____________________________________________________________");
        System.out.println(" " + input);
        System.out.println("____________________________________________________________");
    }

    private static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Flaaaash");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    private static void exit() {
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
    
    public static void main(String[] args) {
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
                markTask(Integer.parseInt(inputParts[1]));
                break;

            case "unmark":
                unmarkTask(Integer.parseInt(inputParts[1]));
                break;

            case "todo":
                addTask(new Todo(inputParts[1]));
                break;

            case "deadline":
                String[] deadlineInputDetails = inputParts[1].split(" /by ", 2);
                String deadlineName = deadlineInputDetails[0];
                String deadLine = deadlineInputDetails[1];
                addTask(new Deadline(deadlineName, deadLine));
                break;

            case "event":
                String[] eventInputDetails = inputParts[1].split(" /from | /to ", 3);
                String eventName = eventInputDetails[0];
                String from = eventInputDetails[1];
                String to = eventInputDetails[2];
                addTask(new Event(eventName, from, to));
                break;

            default:
                repeat(command);
            }
        }
    }
}

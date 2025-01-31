public class Flaaaash {
    private static void greet() {
        String greetingLine = "---------------------------------\n"
                + "Hello! I'm Flaaaash\n"
                + "What can I do for you?\n"
                + "---------------------------------";
        System.out.println(greetingLine);
    }

    private static void exit() {
        String exitLine = "Bye. Hope to see you again soon!\n"
                + "---------------------------------\n";
        System.out.println(exitLine);
    }
    
    public static void main(String[] args) {
        greet();
        exit();
    }
}

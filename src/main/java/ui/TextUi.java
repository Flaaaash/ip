package ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static common.Messages.MESSAGE_GOODBYE;
import static common.Messages.MESSAGE_INIT_FAILED;
import static common.Messages.MESSAGE_WELCOME;

/**
 * Text UI of the application.
 */
public class TextUi {
    private static final String DIVIDER = "____________________________________________________________";

    private final Scanner in;
    private final PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Generates and prints the welcome message upon the start of the application.
     * @param version current version of the application.
     */
    public void showWelcomeMessage(String version) {
        showToUser(
                DIVIDER,
                version,
                MESSAGE_WELCOME,
                DIVIDER);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        out.print("Enter command: ");
        String fullInputLine = in.nextLine().trim();
        out.println("[Command entered: " + fullInputLine + "]");
        return fullInputLine;
    }

    /** Shows message(s) to the user */
    public void showToUser(String... message) {
        out.println(DIVIDER);
        for (String m : message) {
            out.println(m);
        }
        out.println(DIVIDER);
    }

    public void showGoodbyeMessage() {
        showToUser(MESSAGE_GOODBYE);
    }

    /** Shows message to the user when failed to initialise the program */
    public void showInitFailedMessage() { showToUser(MESSAGE_INIT_FAILED);}
}

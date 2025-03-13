package ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static common.Messages.MESSAGE_GOODBYE;
import static common.Messages.MESSAGE_INIT_FAILED;
import static common.Messages.MESSAGE_WELCOME;

public class TextUi {
    private static final String DIVIDER = "____________________________________________________________";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final Scanner in;
    private final PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void showWelcomeMessage(String version) {
        showToUser(
                DIVIDER,
                version,
                MESSAGE_WELCOME,
                DIVIDER);
    }

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

    public void showInitFailedMessage() { showToUser(MESSAGE_INIT_FAILED);}
}

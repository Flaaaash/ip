package exceptions;

public class EmptyArgumentException extends ArrayIndexOutOfBoundsException {
    public EmptyArgumentException(String message) {
        super(message);
    }
}

package exception;


import java.io.Serial;

public class MarsRoverException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public MarsRoverException(Exception exception) {
        super(exception);
    }

    public MarsRoverException(String message) {
        super(message);
    }

    public MarsRoverException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarsRoverException() {

    }
}

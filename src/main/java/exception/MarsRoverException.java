package exception;


import java.io.Serial;

public class MarsRoverException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Only exception.
     *
     * @param exception
     */
    public MarsRoverException(Exception exception) {
        super(exception);
    }

    /**
     * Exception with custom message.
     *
     * @param message
     */
    public MarsRoverException(String message) {
        super(message);
    }

    /**
     * Custom message and the cause.
     *
     * @param message
     * @param cause
     */
    public MarsRoverException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarsRoverException() {

    }
}

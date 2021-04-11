package exception;


public class MarsRoverException extends Exception {


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

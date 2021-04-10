package exception;

public class RoverOutOfBoundException extends RuntimeException {

    public RoverOutOfBoundException() {
        super("The Rover went out of the plateau!");
    }
}

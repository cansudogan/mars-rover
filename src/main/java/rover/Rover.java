package rover;

import direction.Direction;
import lombok.Data;
import plateau.Plateau;

@Data
public abstract class Rover {
    private final Plateau plateau;
    private Direction direction;
    private int coordinateX;
    private int coordinateY;

    abstract void turnRight();

    abstract void turnLeft();

    abstract void move();

    abstract void execute();

    public String broadcast() {
        return coordinateX + " "
                + coordinateY + " "
                + getDirection().getClass().getSimpleName().charAt(0);
    }

    public void validateLocation() {
        if (getCoordinateX() < plateau.getLowerBoundX() ||
                getCoordinateX() > plateau.getUpperBoundX() ||
                getCoordinateY() < plateau.getLowerBoundX() ||
                getCoordinateY() > plateau.getUpperBoundY()) {
            throw new RoverOutOfBoundException();
        }
    }

}

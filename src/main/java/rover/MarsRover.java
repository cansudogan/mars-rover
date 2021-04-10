package rover;

import direction.Direction;
import directionOrder.DirectionOrder;
import exception.MarsRoverException;
import lombok.Data;
import plateau.Plateau;

import java.util.List;

@Data
public class MarsRover {
    private Plateau plateau;
    private Direction direction;
    private int coordinateX;
    private int coordinateY;

    public MarsRover(Plateau plateau, Direction direction, int coordinateX, int coordinateY) {
        this.plateau = plateau;
        this.direction = direction;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }


    public void turnRight() {
        setDirection(getDirection().turnRight());
    }


    public void turnLeft() {
        setDirection(getDirection().turnLeft());
    }

    public void move() throws MarsRoverException {
        getDirection().move(this);
        validateLocation();
    }


    public void launch(List<DirectionOrder> directionOrders) throws MarsRoverException {
        for (DirectionOrder c : directionOrders) {
            c.launch(this);
        }
    }


    public String broadcast() {
        return coordinateX + " "
                + coordinateY + " "
                + getDirection().getClass().getSimpleName().charAt(0);
    }

    public void validateLocation() throws MarsRoverException {
        if (getCoordinateX() < plateau.getLowerBoundX() ||
                getCoordinateX() > plateau.getUpperBoundX() ||
                getCoordinateY() < plateau.getLowerBoundX() ||
                getCoordinateY() > plateau.getUpperBoundY()) {
            throw new MarsRoverException();
        }
    }

}

package rover;

import direction.Direction;
import directionOrder.DirectionOrder;
import exception.MarsRoverException;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import plateau.Plateau;

import java.util.List;

@Getter
@Setter

public class MarsRover {

    private static final Logger logger = LogManager.getLogger(MarsRover.class);

    private Plateau plateau;
    private Direction direction;
    private int coordinateX;
    private int coordinateY;

    /**
     * Constructor to initialize MarsRover's position.
     *
     * @param plateau
     * @param direction
     * @param coordinateX
     * @param coordinateY
     */
    public MarsRover(Plateau plateau, Direction direction, int coordinateX, int coordinateY) throws MarsRoverException {
        if (plateau == null) throw new NullPointerException("The Plateau you create the Rover in cannot be null!");
        if (direction == null) throw new NullPointerException("The Direction the Rover is facing in cannot be null!");

        this.plateau = plateau;
        this.direction = direction;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        validateLocation();
    }

    /**
     *
     */
    public void turnRight() {
        setDirection(getDirection().turnRight());
    }

    /**
     *
     */
    public void turnLeft() {
        setDirection(getDirection().turnLeft());
    }

    /**
     * @throws MarsRoverException
     */
    public void move() throws MarsRoverException {
        getDirection().move(this);
        validateLocation();
    }

    /**
     * @param directionOrders
     * @throws MarsRoverException
     */
    public void launch(List<DirectionOrder> directionOrders) throws MarsRoverException {
        for (DirectionOrder c : directionOrders) {
            c.launch(this);
        }
    }

    /**
     * @return
     */
    public String broadcast() {
        return coordinateX + " "
                + coordinateY + " "
                + getDirection().getClass().getSimpleName().charAt(0);
    }

    /**
     * @throws MarsRoverException
     */
    public void validateLocation() throws MarsRoverException {

        if (getCoordinateX() < plateau.getLowerBoundX() ||
                getCoordinateX() > plateau.getUpperBoundX() ||
                getCoordinateY() < plateau.getLowerBoundX() ||
                getCoordinateY() > plateau.getUpperBoundY()) {
            logger.error("MarsRover out of bound!");
            throw new MarsRoverException("MarsRover out of bound!");
        }
    }

}

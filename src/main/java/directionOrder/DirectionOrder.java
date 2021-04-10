package directionOrder;

import exception.MarsRoverException;
import rover.MarsRover;

public interface DirectionOrder {
    void launch(MarsRover marsRover) throws MarsRoverException;
}

package directionOrder.implementation;

import directionOrder.DirectionOrder;
import exception.MarsRoverException;
import lombok.ToString;
import rover.MarsRover;

@ToString
public class Move implements DirectionOrder {
    @Override
    public void launch(MarsRover marsRover) throws MarsRoverException {
        marsRover.move();
    }
}

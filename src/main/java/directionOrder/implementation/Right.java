package directionOrder.implementation;

import directionOrder.DirectionOrder;
import lombok.ToString;
import rover.MarsRover;

@ToString
public class Right implements DirectionOrder {
    @Override
    public void launch(MarsRover marsRover) {
        marsRover.turnRight();
    }
}

package command.implementation;

import command.DirectionOrder;
import lombok.ToString;
import rover.MarsRover;

@ToString
public class Move implements DirectionOrder {
    @Override
    public void launch(MarsRover marsRover) {
        marsRover.move();
    }
}

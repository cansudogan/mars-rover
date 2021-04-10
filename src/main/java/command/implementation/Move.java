package command.implementation;

import command.DirectionOrder;
import lombok.ToString;
import rover.Rover;
@ToString
public class Move implements DirectionOrder {
    @Override
    public void launch(Rover rover) {
        rover.move();
    }
}

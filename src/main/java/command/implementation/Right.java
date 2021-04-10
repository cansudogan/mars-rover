package command.implementation;

import command.DirectionOrder;
import lombok.ToString;
import rover.Rover;
@ToString
public class Right implements DirectionOrder {
    @Override
    public void launch(Rover rover) {
        rover.turnRight();
    }
}

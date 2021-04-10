package command.implementation;

import command.Command;
import lombok.ToString;
import rover.Rover;
@ToString
public class Right implements Command {
    @Override
    public void launch(Rover rover) {
        rover.turnRight();
    }
}

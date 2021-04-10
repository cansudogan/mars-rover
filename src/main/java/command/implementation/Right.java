package command.implementation;

import command.Command;
import rover.Rover;

public class Right implements Command {
    @Override
    public void launch(Rover rover) {
        rover.turnRight();
    }
}

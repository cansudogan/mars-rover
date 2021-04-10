package command.implementation;

import command.Command;
import rover.Rover;

public class Left implements Command {
    @Override
    public void launch(Rover rover) {
        rover.turnLeft();
    }
}

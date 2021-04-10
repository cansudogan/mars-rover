package command.implementation;

import command.Command;
import rover.Rover;

public class Move implements Command {
    @Override
    public void launch(Rover rover) {
        rover.move();
    }
}

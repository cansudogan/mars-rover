package command.implementation;

import command.Command;
import lombok.ToString;
import rover.Rover;
@ToString
public class Move implements Command {
    @Override
    public void launch(Rover rover) {
        rover.move();
    }
}

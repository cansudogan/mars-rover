package command.implementation;

import command.Command;
import lombok.ToString;
import rover.Rover;
@ToString
public class Left implements Command {
    @Override
    public void launch(Rover rover) {
        rover.turnLeft();
    }
}

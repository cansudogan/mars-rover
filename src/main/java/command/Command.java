package command;

import rover.Rover;

public interface Command {
    void launch(Rover rover);
}

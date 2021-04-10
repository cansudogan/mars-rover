package direction.implementation;

import direction.Direction;
import rover.Rover;

public class South implements Direction {
    @Override
    public Direction turnRight() {
        return new West();
    }

    @Override
    public Direction turnLeft() {
        return new East();
    }

    @Override
    public void move(Rover rover) {

    }
}

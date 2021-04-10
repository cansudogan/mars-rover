package direction.implementation;

import direction.Direction;
import rover.Rover;

public class East implements Direction {
    @Override
    public Direction turnRight() { return new South(); }

    @Override
    public Direction turnLeft() {
        return new North();
    }

    @Override
    public void move(Rover rover) {
    }
}

package direction.implementation;

import direction.Direction;
import rover.Rover;

public class West implements Direction {
    @Override
    public Direction turnRight() {
        return new North();
    }

    @Override
    public Direction turnLeft() {
        return new South();
    }

    @Override
    public void move(Rover rover) {

    }
}

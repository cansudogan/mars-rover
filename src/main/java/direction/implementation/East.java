package direction.implementation;

import direction.Direction;
import lombok.ToString;
import rover.Rover;
@ToString
public class East implements Direction {
    @Override
    public Direction turnRight() {
        return new South();
    }

    @Override
    public Direction turnLeft() {
        return new North();
    }

    @Override
    public void move(Rover rover) {
        rover.setCoordinateX(rover.getCoordinateX() + 1);
    }
}

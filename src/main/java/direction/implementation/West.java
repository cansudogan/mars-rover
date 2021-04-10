package direction.implementation;

import direction.Direction;
import lombok.ToString;
import rover.MarsRover;

@ToString
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
    public void move(MarsRover marsRover) {
        marsRover.setCoordinateX(marsRover.getCoordinateX() - 1);
    }
}

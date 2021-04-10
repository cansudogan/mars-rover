package direction.implementation;

import direction.Direction;
import lombok.ToString;
import rover.MarsRover;

@ToString
public class North implements Direction {
    @Override
    public Direction turnRight() {
        return new East();
    }

    @Override
    public Direction turnLeft() {
        return new West();
    }

    @Override
    public void move(MarsRover marsRover) {
        marsRover.setCoordinateY(marsRover.getCoordinateY() + 1);
    }
}

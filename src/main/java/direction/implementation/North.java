package direction.implementation;

import direction.Direction;
import lombok.ToString;
import rover.Rover;
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
    public void move(Rover rover) {
        rover.setCoordinateY(rover.getCoordinateY() + 1);
    }
}

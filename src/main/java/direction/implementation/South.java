package direction.implementation;

import direction.Direction;
import lombok.ToString;
import rover.Rover;
@ToString
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
        rover.setCoordinateY(rover.getCoordinateY() - 1);
    }
}

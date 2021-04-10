package rover;

import direction.Direction;
import lombok.Data;
import plateau.Plateau;

@Data
public class MarsRover implements Rover{

    private final Plateau plateau;
    private Direction direction;
    private int coordinateX;
    private int coordinateY;

    @Override
    public void turnRight() {
        direction = getDirection().turnRight();
    }

    @Override
    public void turnLeft() {
        direction =getDirection().turnLeft();
    }

    @Override
    public void move() {
        getDirection().move(this);
    }

    @Override
    public void execute() {

    }
}

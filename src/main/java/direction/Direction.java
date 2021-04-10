package direction;

import rover.MarsRover;


public interface Direction {
    Direction turnRight();

    Direction turnLeft();

    void move(MarsRover marsRover);
}

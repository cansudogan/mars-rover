package direction;

import rover.Rover;

public interface Direction {
    Direction turnRight();

    Direction turnLeft();

    void move(Rover rover);
}

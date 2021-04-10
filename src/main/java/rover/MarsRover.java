package rover;

import plateau.Plateau;


public class MarsRover extends Rover {

    public MarsRover(Plateau plateau) {
        super(plateau);
    }

    @Override
    public void turnRight() {
        super.setDirection(getDirection().turnRight());
    }

    @Override
    public void turnLeft() {
        super.setDirection(getDirection().turnLeft());
    }

    @Override
    public void move() {
        super.getDirection().move(this);
    }

    @Override
    public void execute() {

    }
}

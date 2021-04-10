package rover;

import plateau.Plateau;


public class MarsRover extends Rover {

    public MarsRover(Plateau plateau) {
        super(plateau);
    }


    @Override
    public void turnRight() {
        setDirection(getDirection().turnRight());
    }

    @Override
    public void turnLeft() {
        setDirection(getDirection().turnLeft());
    }

    @Override
    public void move() {
        getDirection().move(this);
        validateLocation();
    }


}

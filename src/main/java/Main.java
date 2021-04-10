import direction.implementation.East;
import plateau.Plateau;
import rover.MarsRover;

public class Main {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        East east = new East();
        marsRover.setCoordinateX(1);
        marsRover.setCoordinateY(0);
        marsRover.setDirection(east);
        System.out.println(marsRover.broadcast());
        marsRover.turnLeft();
        marsRover.move();
        System.out.println(marsRover.broadcast());
    }
}

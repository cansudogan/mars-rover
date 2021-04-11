package directionOrders;

import direction.implementation.East;
import direction.implementation.North;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;

public class TurnRightTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;


    @Test
    public void whenTurnRightIsExecutedRoverTurnsRight() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        marsRover.turnRight();
        Assertions.assertEquals(East.class, marsRover.getDirection().getClass());
    }
}

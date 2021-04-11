package directionOrders;

import direction.implementation.North;
import direction.implementation.West;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;

public class TurnLeftTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenTurnLeftIsExecutedRoverTurnsLeft() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        marsRover.turnLeft();
        Assertions.assertEquals(West.class, marsRover.getDirection().getClass());
    }
}

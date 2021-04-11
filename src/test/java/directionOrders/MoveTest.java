package directionOrders;

import direction.implementation.North;
import direction.implementation.South;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;

public class MoveTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenMoveOrderIsExecutedRoverMovesForward() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        marsRover.move();
        Assertions.assertEquals(++yCoordinate, marsRover.getCoordinateY());
    }

    @Test
    public void whenMoveOrderIsExecutedRoverMovesBack() throws Exception {
        marsRover = new MarsRover(plateau, new South(), xCoordinate, yCoordinate);
        marsRover.move();
        Assertions.assertEquals(--yCoordinate, marsRover.getCoordinateY());
    }
}

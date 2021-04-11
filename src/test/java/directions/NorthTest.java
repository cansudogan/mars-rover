package directions;

import direction.implementation.East;
import direction.implementation.North;
import direction.implementation.West;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;


public class NorthTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenNorthDirectionTurnsRightNewDirectionIsEast() {
        Assertions.assertEquals(East.class, new North().turnRight().getClass());
    }

    @Test
    public void whenNorthDirectionTurnsLeftNewDirectionIsWest() {
        Assertions.assertEquals(West.class, new North().turnLeft().getClass());
    }

    @Test
    public void whenNorthDirectionMovesCoordinateYIncrements() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        new North().move(marsRover);
        Assertions.assertEquals(++yCoordinate, marsRover.getCoordinateY());
    }

}

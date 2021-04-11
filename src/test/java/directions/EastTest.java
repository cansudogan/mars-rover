package directions;

import direction.implementation.East;
import direction.implementation.North;
import direction.implementation.South;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;

public class EastTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenEastDirectionTurnsRightNewDirectionIsSouth() {
        Assertions.assertEquals(South.class, new East().turnRight().getClass());
    }

    @Test
    public void whenEastDirectionTurnsLeftNewDirectionIsNorth() {
        Assertions.assertEquals(North.class, new East().turnLeft().getClass());
    }

    @Test
    public void whenEastDirectionMovesCoordinateXIncrements() throws Exception {
        marsRover = new MarsRover(plateau, new East(), xCoordinate, yCoordinate);
        new East().move(marsRover);
        Assertions.assertEquals(++xCoordinate, marsRover.getCoordinateX());
    }
}

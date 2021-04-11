package directions;

import direction.implementation.North;
import direction.implementation.South;
import direction.implementation.West;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;


public class WestTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenWestDirectionTurnsRightNewDirectionIsNorth() {
        Assertions.assertEquals(new West().turnRight().getClass(), North.class);
    }

    @Test
    public void whenWestDirectionTurnsLeftNewDirectionIsSouth() {
        Assertions.assertEquals(new West().turnLeft().getClass(), South.class);
    }

    @Test
    public void whenWestDirectionMovesCoordinateXDecrements() throws Exception {
        marsRover = new MarsRover(plateau, new West(), xCoordinate, yCoordinate);
        new West().move(marsRover);
        Assertions.assertEquals(--xCoordinate, marsRover.getCoordinateX());
    }
}

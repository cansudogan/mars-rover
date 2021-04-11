package directions;

import direction.implementation.East;
import direction.implementation.South;
import direction.implementation.West;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;


public class SouthTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenSouthDirectionTurnsRightNewDirectionIsWest() {
        Assertions.assertEquals(West.class, new South().turnRight().getClass());
    }

    @Test
    public void whenSouthDirectionTurnsLeftNewDirectionIsEast() {
        Assertions.assertEquals(East.class, new South().turnLeft().getClass());
    }

    @Test
    public void whenSouthDirectionMovesCoordinateYDecrements() throws Exception {
        marsRover = new MarsRover(plateau, new South(), xCoordinate, yCoordinate);
        new South().move(marsRover);
        Assertions.assertEquals(--yCoordinate, marsRover.getCoordinateY());
    }

}

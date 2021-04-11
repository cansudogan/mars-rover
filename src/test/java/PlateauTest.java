import direction.implementation.North;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;


public class PlateauTest {
    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenPlateauIsConstructedLowerBoundsAreZeroZero() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        Assertions.assertEquals(0, plateau.getLowerBoundX());
        Assertions.assertEquals(0, plateau.getLowerBoundY());
    }
}

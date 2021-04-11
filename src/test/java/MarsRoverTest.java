import direction.implementation.East;
import direction.implementation.North;
import direction.implementation.West;
import directionOrder.DirectionOrder;
import directionOrder.implementation.Left;
import directionOrder.implementation.Move;
import directionOrder.implementation.Right;
import exception.MarsRoverException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;

import java.util.ArrayList;

public class MarsRoverTest {

    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected MarsRover marsRover;

    @Test
    public void whenRequestedRoverCanTurnRight() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        marsRover.turnRight();
        Assertions.assertEquals(East.class, marsRover.getDirection().getClass());
    }

    @Test
    public void whenRequestedRoverCanTurnLeft() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        marsRover.turnLeft();
        Assertions.assertEquals(West.class, marsRover.getDirection().getClass());
    }

    @Test
    public void whenRequestedRoverCanMove() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        marsRover.move();
        Assertions.assertEquals(++yCoordinate, marsRover.getCoordinateY());
    }

    @Test
    public void whenRequestedRoverCanPrintCurrentPosition() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        Assertions.assertEquals(xCoordinate + " "
                + yCoordinate + " "
                + marsRover.getDirection().getClass().getSimpleName().charAt(0), marsRover.broadcast());
    }

    @Test
    public void whenRequestedRoverCanLaunchDirectionOrderAsAList() throws Exception {
        marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
        ArrayList<DirectionOrder> orderArrayList = new ArrayList<>();
        orderArrayList.add(new Move());
        orderArrayList.add(new Move());
        orderArrayList.add(new Left());
        orderArrayList.add(new Move());
        orderArrayList.add(new Right());
        marsRover.launch(orderArrayList);

        Assertions.assertEquals(1, marsRover.getCoordinateX());
        Assertions.assertEquals(4, marsRover.getCoordinateY());
        Assertions.assertEquals(North.class, marsRover.getDirection().getClass());
    }

    @Test
    public void whenGivenInputIsRunCorrectOutputIsReturned() throws MarsRoverException {
        Plateau plateau = new Plateau(5, 5);

        MarsRover roverOne = new MarsRover(plateau, new North(), 1, 2);

        ArrayList<DirectionOrder> roverOneOrders = new ArrayList<>();
        roverOneOrders.add(new Left());
        roverOneOrders.add(new Move());
        roverOneOrders.add(new Left());
        roverOneOrders.add(new Move());
        roverOneOrders.add(new Left());
        roverOneOrders.add(new Move());
        roverOneOrders.add(new Left());
        roverOneOrders.add(new Move());
        roverOneOrders.add(new Move());
        roverOne.launch(roverOneOrders);

        MarsRover roverTwo = new MarsRover(plateau, new East(), 3, 3);

        ArrayList<DirectionOrder> roverTwoOrders = new ArrayList<>();
        roverTwoOrders.add(new Move());
        roverTwoOrders.add(new Move());
        roverTwoOrders.add(new Right());
        roverTwoOrders.add(new Move());
        roverTwoOrders.add(new Move());
        roverTwoOrders.add(new Right());
        roverTwoOrders.add(new Move());
        roverTwoOrders.add(new Right());
        roverTwoOrders.add(new Right());
        roverTwoOrders.add(new Move());
        roverTwo.launch(roverTwoOrders);

        Assertions.assertEquals(1, roverOne.getCoordinateX());
        Assertions.assertEquals(3, roverOne.getCoordinateY());
        Assertions.assertEquals(North.class, roverOne.getDirection().getClass());

        Assertions.assertEquals(5, roverTwo.getCoordinateX());
        Assertions.assertEquals(1, roverTwo.getCoordinateY());
        Assertions.assertEquals(East.class, roverTwo.getDirection().getClass());
    }

    @Test()
    public void whenRoverIsCreatedWithANullPlateauExceptionIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new MarsRover(null, new North(), xCoordinate, yCoordinate));
    }


    @Test()
    public void whenRoverIsCreatedWithANullDirectionExceptionIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new MarsRover(plateau, null, xCoordinate, yCoordinate));
    }

    @Test()
    public void whenRoverIsCreatedOutOfPlateauBoundsExceptionIsThrown() {
        Assertions.assertThrows(MarsRoverException.class,
                () -> new MarsRover(plateau, new North(), -1, 6));
    }

    @Test()
    public void whenRoverMovesOutOfNorthBoundsExceptionIsThrown() {
        Assertions.assertThrows(MarsRoverException.class,
                () -> {
                    MarsRover marsRover = new MarsRover(plateau, new North(), xCoordinate, yCoordinate);
                    marsRover.setCoordinateX(plateau.getUpperBoundX());
                    marsRover.setCoordinateY(plateau.getUpperBoundY());
                    marsRover.move();
                });
    }

    @Test()
    public void whenRoverMovesOutOfEastBoundsExceptionIsThrown() {
        Assertions.assertThrows(MarsRoverException.class,
                () -> {
                    MarsRover marsRover = new MarsRover(plateau, new East(), xCoordinate, yCoordinate);
                    marsRover.setCoordinateX(plateau.getLowerBoundX());
                    marsRover.setCoordinateY(plateau.getLowerBoundY());
                    marsRover.turnRight();
                    marsRover.move();
                });
    }

    @Test()
    public void whenRoverMovesOutOfWestBoundsExceptionIsThrown() {
        Assertions.assertThrows(MarsRoverException.class,
                () -> {
                    MarsRover marsRover = new MarsRover(plateau, new West(), xCoordinate, yCoordinate);
                    marsRover.setCoordinateX(plateau.getLowerBoundX());
                    marsRover.setCoordinateY(plateau.getLowerBoundY());
                    marsRover.turnLeft();
                    marsRover.move();
                });
    }
}
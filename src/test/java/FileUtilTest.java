import direction.implementation.North;
import directionOrder.DirectionOrder;
import directionOrder.implementation.Left;
import directionOrder.implementation.Move;
import directionOrder.implementation.Right;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import rover.MarsRover;

import java.io.InputStream;
import java.util.List;

public class FileUtilTest {
    protected final Plateau plateau = new Plateau(5, 5);


    @Test
    public void inputStringsCanBeReadFromFile() throws Exception {
        InputStream testFileInputStream = getClass().getResourceAsStream("/input.txt");
        String expectedInputStringOne = "5 5";
        String expectedInputStringTwo = "1 2 N";
        String expectedInputStringThree = "LMLMLMLMM";
        String expectedInputStringFour = "3 3 E";
        String expectedInputStringFive = "MMRMMRMRRM";
        List<String> testFileLines = FileUtil.readInputFromFile(testFileInputStream);

        Assertions.assertEquals(5, testFileLines.size());
        Assertions.assertEquals(expectedInputStringOne, testFileLines.get(0));
        Assertions.assertEquals(expectedInputStringTwo, testFileLines.get(1));
        Assertions.assertEquals(expectedInputStringThree, testFileLines.get(2));
        Assertions.assertEquals(expectedInputStringFour, testFileLines.get(3));
        Assertions.assertEquals(expectedInputStringFive, testFileLines.get(4));
    }

    @Test
    public void whenPlateauInputIsCreatedPlateauIsConstructed() throws Exception {
        String plateauInput = "5 5";
        Plateau plateauOutput = FileUtil.CreatePlateau(plateauInput);

        Assertions.assertEquals(0, plateauOutput.getLowerBoundX());
        Assertions.assertEquals(0, plateauOutput.getLowerBoundY());
        Assertions.assertEquals(5, plateauOutput.getUpperBoundX());
        Assertions.assertEquals(5, plateauOutput.getUpperBoundY());
    }

    @Test
    public void whenPositionInputIsCreatedMarsRoverIsConstructed() throws Exception {
        String positionInput = "1 2 N";
        MarsRover roverOutput = FileUtil.CreateMarsRover(positionInput, plateau);

        Assertions.assertEquals(1, roverOutput.getCoordinateX());
        Assertions.assertEquals(2, roverOutput.getCoordinateY());
        Assertions.assertEquals(North.class, roverOutput.getDirection().getClass());
    }

    @Test
    public void whenRCommandIsParsedSpinRightCommandIsConstructed() {
        String rCommandInput = "R";
        List<DirectionOrder> commandOutput = FileUtil.readDirectionOrder(rCommandInput);

        Assertions.assertEquals(rCommandInput.length(), commandOutput.size());
        Assertions.assertEquals(Right.class, commandOutput.get(0).getClass());
    }

    @Test
    public void whenLCommandIsParsedSpinLeftCommandIsConstructed() {
        String lCommandInput = "L";
        List<DirectionOrder> commandOutput = FileUtil.readDirectionOrder(lCommandInput);

        Assertions.assertEquals(lCommandInput.length(), commandOutput.size());
        Assertions.assertEquals(Left.class, commandOutput.get(0).getClass());
    }

    @Test
    public void whenMCommandIsParsedMoveForwardCommandIsConstructed() {
        String mCommandInput = "M";
        List<DirectionOrder> commandOutput = FileUtil.readDirectionOrder(mCommandInput);

        Assertions.assertEquals(mCommandInput.length(), commandOutput.size());
        Assertions.assertEquals(Move.class, commandOutput.get(0).getClass());
    }

    @Test
    public void whenMultipleDirectionOrdersAreReadDirectionOrderIsConstructed() {
        String multiCommandInput = "RLM";
        List<DirectionOrder> commandOutput = FileUtil.readDirectionOrder(multiCommandInput);

        Assertions.assertEquals(multiCommandInput.length(), commandOutput.size());
        Assertions.assertEquals(Right.class, commandOutput.get(0).getClass());
        Assertions.assertEquals(Left.class, commandOutput.get(1).getClass());
        Assertions.assertEquals(Move.class, commandOutput.get(2).getClass());
    }
}
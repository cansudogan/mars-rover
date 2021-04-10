import direction.Direction;
import direction.Directions;
import directionOrder.DirectionOrder;
import directionOrder.DirectionOrders;
import exception.MarsRoverException;
import plateau.Plateau;
import rover.MarsRover;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    static final String SPACE = " ";


    static List<DirectionOrder> readCommand(String s) {
        char[] inputArray = s.toCharArray();
        ArrayList<DirectionOrder> directionOrderArrayList = new ArrayList<>();

        for (char character : inputArray) {
            DirectionOrder currentDirectionOrder = DirectionOrders.valueOf(Character.toString(character)).getDirectionOrder();
            directionOrderArrayList.add(currentDirectionOrder);
        }

        return directionOrderArrayList;
    }

    public static List<String> readInputFromFile(InputStream in) throws MarsRoverException {
        try {
            List<String> input = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
            reader.close();
            return input;
        } catch (FileNotFoundException fnf) {
            throw new MarsRoverException("Unable to locate the input file:" + in + ", Error:", fnf);
        } catch (IOException ioe) {
            throw new MarsRoverException("Error in reading input file:" + in + ", Error:", ioe);
        }

    }

    public static Plateau CreatePlateau(String plateauInput) throws MarsRoverException {
        String[] inputArray = plateauInput.split(SPACE);
        if (inputArray.length != 2) {
            throw new MarsRoverException("Please give plateau's both top and right co-ordinates");
        }
        int UpperBoundX = Integer.parseInt(inputArray[0]);
        int UpperBoundY = Integer.parseInt(inputArray[1]);
        return new Plateau(UpperBoundX, UpperBoundY);
    }

    public static MarsRover CreateMarsRover(String positionInput, Plateau plateau) throws MarsRoverException {
        String[] inputArray = positionInput.split(SPACE);
        if (inputArray.length != 3) {
            throw new MarsRoverException("Invalid initial position:'" + positionInput + "' received!");
        }
        int initialCoordinateX = Integer.parseInt(inputArray[0]);
        int initialCoordinateY = Integer.parseInt(inputArray[1]);
        Direction direction = Directions.valueOf(inputArray[2]).getDirection();
        return new MarsRover(plateau, direction, initialCoordinateX, initialCoordinateY);
    }

}

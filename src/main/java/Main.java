import command.DirectionOrder;
import command.DirectionOrders;
import direction.Direction;
import direction.Directions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import plateau.Plateau;
import rover.MarsRover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        logger.info("Reading from input.txt!!");
        List<String> inputList = readInputFromFile(Main.class.getResourceAsStream("/input.txt"));
        logger.info("All Input: " + inputList);
        List<String> roverInput = inputList.subList(1, inputList.size());
        logger.info("Rover Input: " + roverInput);

        logger.info("creating plateau!!");


        Plateau plateau = readPlateauInput(inputList.get(0));
        logger.info(plateau);

        for (int i = 0; i < roverInput.size(); i += 2) {
            MarsRover marsRover = CreateMarsRover(roverInput.get(i), plateau);
            logger.info(marsRover);
            List<DirectionOrder> directionOrders = readCommand(roverInput.get(i + 1));
            logger.info(directionOrders);
            marsRover.launch(directionOrders);
            logger.info(marsRover.broadcast());
        }
    }

    private static List<DirectionOrder> readCommand(String s) {
        char[] inputArray = s.toCharArray();
        ArrayList<DirectionOrder> directionOrderArrayList = new ArrayList<>();

        for (char character : inputArray) {
            DirectionOrder currentDirectionOrder = DirectionOrders.valueOf(Character.toString(character)).getDirectionOrder();
            directionOrderArrayList.add(currentDirectionOrder);
        }

        return directionOrderArrayList;
    }


    public static List<String> readInputFromFile(InputStream in) throws IOException {
        List<String> input = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;

        while ((line = reader.readLine()) != null) {
            input.add(line);
        }
        reader.close();
        return input;
    }


    public static Plateau readPlateauInput(String plateauInput) {
        String[] inputArray = plateauInput.split(" ");
        int UpperBoundX = Integer.parseInt(inputArray[0]);
        int UpperBoundY = Integer.parseInt(inputArray[1]);
        return new Plateau(UpperBoundX, UpperBoundY);
    }

    public static MarsRover CreateMarsRover(String positionInput, Plateau plateau) {
        String[] inputArray = positionInput.split(" ");
        int initialCoordinateX = Integer.parseInt(inputArray[0]);
        int initialCoordinateY = Integer.parseInt(inputArray[1]);
        Direction direction = Directions.valueOf(inputArray[2]).getDirection();
        return new MarsRover(plateau, direction, initialCoordinateX, initialCoordinateY);
    }

}

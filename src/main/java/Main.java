import directionOrder.DirectionOrder;
import exception.MarsRoverException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import plateau.Plateau;
import rover.MarsRover;

import java.util.List;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws MarsRoverException {


        logger.info("Reading from input.txt!!");
        List<String> inputList = FileUtil.readInputFromFile(Main.class.getResourceAsStream("/input.txt"));
        logger.info("All Input: " + inputList);
        List<String> roverInput = inputList.subList(1, inputList.size());
        logger.info("Rover Input: " + roverInput);
        logger.info("creating plateau!!");
        Plateau plateau = FileUtil.CreatePlateau(inputList.get(0));
        logger.info(plateau);

        for (int i = 0; i < roverInput.size(); i += 2) {
            MarsRover marsRover = FileUtil.CreateMarsRover(roverInput.get(i), plateau);
            logger.info(marsRover);
            List<DirectionOrder> directionOrders = FileUtil.readCommand(roverInput.get(i + 1));
            logger.info(directionOrders);
            marsRover.launch(directionOrders);
            logger.info(marsRover.broadcast());
        }

    }


}

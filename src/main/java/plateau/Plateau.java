package plateau;

import lombok.Data;

/**
 * Holds rectangular plateau's coordinates.
 *
 * @author Cansu Doğan
 */
@Data
public class Plateau {

    private final int lowerBoundX = 0;

    private final int lowerBoundY = 0;

    private final int upperBoundX;

    private final int upperBoundY;
}

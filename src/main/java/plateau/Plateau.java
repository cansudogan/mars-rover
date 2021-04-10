package plateau;

import lombok.Data;

@Data
public class Plateau {
    private final int lowerBoundX = 0;
    private final int lowerBoundY = 0;
    private final int upperBoundX;
    private final int upperBoundY;
}

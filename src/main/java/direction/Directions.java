package direction;

import direction.implementation.East;
import direction.implementation.North;
import direction.implementation.South;
import direction.implementation.West;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Directions {
    N(new North()),

    E(new East()),

    S(new South()),

    W(new West());

    private final Direction direction;

}

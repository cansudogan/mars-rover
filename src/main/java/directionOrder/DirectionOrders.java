package directionOrder;

import directionOrder.implementation.Left;
import directionOrder.implementation.Move;
import directionOrder.implementation.Right;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DirectionOrders {
    R(new Right()),

    L(new Left()),

    M(new Move());

    private final DirectionOrder directionOrder;

}

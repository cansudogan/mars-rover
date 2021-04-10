package command;

import command.implementation.Left;
import command.implementation.Move;
import command.implementation.Right;
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

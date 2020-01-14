package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.Command;
import com.thoughtworks.marsrover.model.Direction;
import com.thoughtworks.marsrover.model.Status;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TurnLeftCommandProcessor implements CommandProcessor {

    private Map<Direction, Direction> turnRightActionLookUp = Stream.of(new Object[][] {
        {Direction.E, Direction.N},
        {Direction.S, Direction.E},
        {Direction.W, Direction.S},
        {Direction.N, Direction.W}
    }).collect(Collectors.toMap(data -> (Direction) data[0], data -> (Direction) data[1]));

    public boolean isMatched(String command) {
        return Command.L.toString().equalsIgnoreCase(command);
    }

    @Override
    public void processCommand(Status status) {
        status.setDirection(turnRightActionLookUp.get(status.getDirection()));
    }
}

package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.Command;
import com.thoughtworks.marsrover.model.Direction;
import com.thoughtworks.marsrover.model.Location;
import com.thoughtworks.marsrover.model.Status;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveCommandProcessor implements CommandProcessor{

    private Map<Direction, Location> moveActionLookUp = Stream.of(new Object[][] {
            {Direction.E, new Location(1, 0)},
            {Direction.S, new Location(0, -1)},
            {Direction.W, new Location(-1, 0)},
            {Direction.N, new Location(0, 1)}
    }).collect(Collectors.toMap(data -> (Direction) data[0], data -> (Location) data[1]));

    @Override
    public boolean isMatched(String command) {
        return Command.M.toString().equalsIgnoreCase(command);
    }

    @Override
    public void processCommand(Status status) {
        if (!status.isReverse()) {
            status.getLocation().add(moveActionLookUp.get(status.getDirection()));
        } else {
            status.getLocation().minus(moveActionLookUp.get(status.getDirection()));
        }
    }
}

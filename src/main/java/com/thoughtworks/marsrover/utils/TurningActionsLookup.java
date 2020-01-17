package com.thoughtworks.marsrover.utils;

import com.thoughtworks.marsrover.model.rovers.properties.Direction;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TurningActionsLookup {

    public static Map<Direction, Direction> TurnLeftActionLookUp = Stream.of(new Object[][] {
            {Direction.E, Direction.N},
            {Direction.S, Direction.E},
            {Direction.W, Direction.S},
            {Direction.N, Direction.W}
    }).collect(Collectors.toMap(data -> (Direction) data[0], data -> (Direction) data[1]));

    public static Map<Direction, Direction> TurnRightActionLookUp = Stream.of(new Object[][] {
            {Direction.E, Direction.S},
            {Direction.S, Direction.W},
            {Direction.W, Direction.N},
            {Direction.N, Direction.E}
    }).collect(Collectors.toMap(data -> (Direction) data[0], data -> (Direction) data[1]));
}

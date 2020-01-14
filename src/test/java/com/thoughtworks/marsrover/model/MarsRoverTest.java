package com.thoughtworks.marsrover.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    @Test
    public void should_move_1_unit_on_north_direction_when_given_M_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.N));

        marsRover.processCommand(Command.M);

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.N, actual.getDirection());
        assertEquals(1, actual.getLocation().getY());
        assertEquals(0, actual.getLocation().getX());
    }

    @Test
    public void should_move_1_unit_on_east_direction_when_given_M_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.E));

        marsRover.processCommand(Command.M);

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.E, actual.getDirection());
        assertEquals(-1, actual.getLocation().getX());
        assertEquals(0, actual.getLocation().getY());
    }
}
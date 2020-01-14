package com.thoughtworks.marsrover.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    @Test
    public void should_move_1_unit_on_current_direction_when_given_M_command() {
        int[] location = new int[] {0, 0};
        MarsRover marsRover = new MarsRover(new Status(location, Direction.N));

        marsRover.processCommand(Command.M);

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.N, actual.getDirection());
        assertArrayEquals(new int[]{0, 1}, actual.getLocation());
    }
}
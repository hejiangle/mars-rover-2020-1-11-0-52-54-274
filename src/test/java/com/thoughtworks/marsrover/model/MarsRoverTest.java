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

    @Test
    public void should_turn_right_to_next_direction_when_given_R_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.E));

        marsRover.processCommand(Command.R);

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.N, actual.getDirection());
        assertEquals(0, actual.getLocation().getX());
        assertEquals(0, actual.getLocation().getY());
    }

    @Test
    public void should_turn_left_to_next_direction_when_given_L_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.S));

        marsRover.processCommand(Command.L);

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.W, actual.getDirection());
        assertEquals(0, actual.getLocation().getX());
        assertEquals(0, actual.getLocation().getY());
    }

    @Test
    public void should_process_all_commands_when_given_a_batch_of_commands(){
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.S));

        marsRover.receiveCommand("abcdefgmnoplmrmm");

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.S, actual.getDirection());
        assertEquals(1, actual.getLocation().getX());
        assertEquals(-3, actual.getLocation().getY());
    }
}
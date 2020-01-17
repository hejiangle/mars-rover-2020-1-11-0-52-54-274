package com.thoughtworks.marsrover.model.rovers;

import com.thoughtworks.marsrover.model.rovers.properties.Direction;
import com.thoughtworks.marsrover.model.rovers.properties.Location;
import com.thoughtworks.marsrover.model.rovers.properties.Radar;
import com.thoughtworks.marsrover.model.rovers.properties.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MarsRoverTest {

    @Test
    public void should_move_1_unit_on_north_direction_when_given_M_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.N));

        marsRover.receiveCommand("m");

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.N, actual.getDirection());
        assertEquals(1, actual.getLocation().getY());
        assertEquals(0, actual.getLocation().getX());
    }

    @Test
    public void should_move_1_unit_on_east_direction_when_given_M_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.E));

        marsRover.receiveCommand("m");

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.E, actual.getDirection());
        assertEquals(1, actual.getLocation().getX());
        assertEquals(0, actual.getLocation().getY());
    }

    @Test
    public void should_turn_right_to_next_direction_when_given_R_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.E));

        marsRover.receiveCommand("r");

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.S, actual.getDirection());
        assertEquals(0, actual.getLocation().getX());
        assertEquals(0, actual.getLocation().getY());
    }

    @Test
    public void should_turn_left_to_next_direction_when_given_L_command() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.S));

        marsRover.receiveCommand("l");

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.E, actual.getDirection());
        assertEquals(0, actual.getLocation().getX());
        assertEquals(0, actual.getLocation().getY());
    }

    @Test
    public void should_return_1_unit_on_north_direction_when_given_M_command_and_rover_is_return_status() {
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.N));

        marsRover.receiveCommand("bm");

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.N, actual.getDirection());
        assertEquals(-1, actual.getLocation().getY());
        assertEquals(0, actual.getLocation().getX());
    }

    @Test
    public void should_process_all_commands_when_given_a_batch_of_commands(){
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.S));

        marsRover.receiveCommand("abcdefgmnoplmrmm");

        Status actual = marsRover.reportLocation();

        assertEquals(Direction.S, actual.getDirection());
        assertEquals(1, actual.getLocation().getX());
        assertEquals(3, actual.getLocation().getY());
    }

    @Test
    public void should_return_true_when_marsRover_is_drop_down_in_pit() {
        Radar radar = mock(Radar.class);
        when(radar.isPit(any(Location.class))).thenReturn(true);
        MarsRover marsRover = new MarsRover(new Status(new Location(0, 0), Direction.S));

        boolean result = marsRover.isDropDown(radar);

        assertTrue(result);
    }
}
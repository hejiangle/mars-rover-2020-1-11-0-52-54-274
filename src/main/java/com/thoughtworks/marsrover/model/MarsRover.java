package com.thoughtworks.marsrover.model;

public class MarsRover {
    private Status status;

    public MarsRover(Status status) {
        this.status = status;
    }

    public Status reportLocation() {
        return status;
    }

    public void processCommand(Command command) {
        int[] location = status.getLocation();
        location[1] += 1;
        status.setLocation(location);
    }
}

package com.thoughtworks.marsrover.model;

public class Status {
    private Location location;
    private Direction direction;


    public Status(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

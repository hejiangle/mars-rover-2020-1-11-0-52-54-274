package com.thoughtworks.marsrover.model;

public class Status {
    private int[] location;
    private Direction direction;


    public Status(int[] location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }


    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

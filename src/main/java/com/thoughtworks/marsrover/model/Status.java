package com.thoughtworks.marsrover.model;

public class Status {
    private Location location;
    private Direction direction;
    private boolean isReverse;

    public Status(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
        this.isReverse = false;
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

    public void modifyReverse() {
        isReverse = !isReverse;
    }

    public boolean isReverse(){
        return isReverse;
    }
}

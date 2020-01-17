package com.thoughtworks.marsrover.model.rovers.properties;

public class Status {
    private Location location;
    private Direction direction;
    private boolean isReverse;
    private boolean canMove;

    public Status(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
        this.isReverse = false;
        this.canMove = true;
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

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
}

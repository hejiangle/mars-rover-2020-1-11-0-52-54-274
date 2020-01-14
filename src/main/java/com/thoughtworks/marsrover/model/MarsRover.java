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
        switch (command) {
            case M:
                processMoveCommand();
                break;
            case L:
                break;
            case R:
                break;
        }
    }

    private void processMoveCommand() {
        Location location = status.getLocation();
        switch (status.getDirection()) {
            case N:
                location.setY(location.getY() + 1);
                break;
            case W:
                location.setX(location.getX() + 1);
                break;
            case S:
                location.setY(location.getY() - 1);
                break;
            case E:
                location.setX(location.getX() - 1);
                break;
        }
        status.setLocation(location);
    }
}

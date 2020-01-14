package com.thoughtworks.marsrover.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarsRover {
    private Status status;

    public MarsRover(Status status) {
        this.status = status;
    }

    public Status reportLocation() {
        return status;
    }

    public void receiveCommand(String input) {
        List<String> matchedCommands = Arrays.stream(Command.values())
                .map(Enum::toString)
                .collect(Collectors.toList());
        Arrays.stream(input.toUpperCase().split(""))
                .filter(matchedCommands::contains)
                .forEach(command -> processCommand(Command.valueOf(command)));
    }

    public void processCommand(Command command) {
        switch (command) {
            case M:
                processMoveCommand();
                break;
            case L:
                processTurnLeftCommand();
                break;
            case R:
                processTurnRightCommand();
                break;
        }
    }

    private void processTurnLeftCommand() {
        status.setDirection(status.getDirection().leftNext());
    }

    private void processTurnRightCommand() {
        status.setDirection(status.getDirection().rightNext());
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

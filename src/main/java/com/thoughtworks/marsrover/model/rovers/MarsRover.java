package com.thoughtworks.marsrover.model.rovers;

import com.thoughtworks.marsrover.component.*;
import com.thoughtworks.marsrover.model.rovers.properties.Radar;
import com.thoughtworks.marsrover.model.rovers.properties.Status;

import java.util.Arrays;
import java.util.List;

public class MarsRover implements CommandReceiver {
    private Status status;

    private List<CommandProcessor> commandProcessors;

    public MarsRover(Status status) {
        this.status = status;
        commandProcessors = Arrays.asList(
                new MoveCommandProcessor(),
                new TurnRightCommandProcessor(),
                new TurnLeftCommandProcessor(),
                new ReverseCommandProcessor());
    }

    public Status reportLocation() {
        return status;
    }

    @Override
    public void receiveCommand(String input) {
        Arrays.stream(input.toUpperCase().split(""))
                .forEach(command -> commandProcessors.stream()
                        .filter(processor -> processor.isMatched(command))
                        .findFirst()
                        .orElse(new DefaultCommandProcessor())
                        .processCommand(status));
    }

    public boolean isDropDown(Radar radar) {
        boolean isPit = radar.isPit(status.getLocation());
        status.setCanMove(!isPit);

        return isPit;
    }
}

package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.rovers.properties.Command;
import com.thoughtworks.marsrover.model.rovers.properties.Status;

public class ReverseCommandProcessor implements CommandProcessor {

    public boolean isMatched(String command) {
        return Command.B.toString().equalsIgnoreCase(command);
    }

    @Override
    public void processCommand(Status status) {
        status.modifyReverse();
    }
}

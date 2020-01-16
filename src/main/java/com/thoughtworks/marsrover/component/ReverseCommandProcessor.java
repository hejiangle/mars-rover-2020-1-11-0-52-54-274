package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.Command;
import com.thoughtworks.marsrover.model.Direction;
import com.thoughtworks.marsrover.model.Status;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseCommandProcessor implements CommandProcessor {

    public boolean isMatched(String command) {
        return Command.B.toString().equalsIgnoreCase(command);
    }

    @Override
    public void processCommand(Status status) {
        status.modifyReverse();
    }
}

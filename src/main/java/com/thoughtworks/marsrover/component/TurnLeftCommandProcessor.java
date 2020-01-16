package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.Command;
import com.thoughtworks.marsrover.model.Direction;
import com.thoughtworks.marsrover.model.Status;
import com.thoughtworks.marsrover.utils.TurningActionsLookup;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TurnLeftCommandProcessor implements CommandProcessor {

    public boolean isMatched(String command) {
        return Command.L.toString().equalsIgnoreCase(command);
    }

    @Override
    public void processCommand(Status status) {
        if (!status.isReverse()) {
            status.setDirection(TurningActionsLookup.TurnLeftActionLookUp.get(status.getDirection()));
        }
        else {
            status.setDirection(TurningActionsLookup.TurnRightActionLookUp.get(status.getDirection()));
        }
    }
}

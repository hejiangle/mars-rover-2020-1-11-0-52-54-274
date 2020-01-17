package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.rovers.properties.Command;
import com.thoughtworks.marsrover.model.rovers.properties.Status;
import com.thoughtworks.marsrover.utils.TurningActionsLookup;

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

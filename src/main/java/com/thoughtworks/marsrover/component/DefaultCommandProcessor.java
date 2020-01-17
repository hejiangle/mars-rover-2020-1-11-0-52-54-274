package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.rovers.properties.Status;

public class DefaultCommandProcessor implements CommandProcessor {

    @Override
    public boolean isMatched(String command) {
        return false;
    }

    @Override
    public void processCommand(Status status) {
        System.out.println("Skip the meaningless command.");
    }
}

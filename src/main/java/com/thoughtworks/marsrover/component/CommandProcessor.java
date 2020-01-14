package com.thoughtworks.marsrover.component;

import com.thoughtworks.marsrover.model.Status;

public interface CommandProcessor {

    boolean isMatched(String command);
    void processCommand(Status status);
}

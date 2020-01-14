package com.thoughtworks.marsrover.model;

public enum Direction {
    N,
    W,
    S,
    E;

    public Direction rightNext() {
        Direction rightNext = null;
        switch (this) {
            case N:
                rightNext = W;
                break;
            case W:
                rightNext = S;
                break;
            case S:
                rightNext = E;
                break;
            case E:
                rightNext = N;
                break;
        }
        return rightNext;
    }

    public Direction leftNext() {
        Direction leftNext = null;
        switch (this) {
            case N:
                leftNext = E;
                break;
            case W:
                leftNext = N;
                break;
            case S:
                leftNext = W;
                break;
            case E:
                leftNext = S;
                break;
        }
        return leftNext;
    }
}

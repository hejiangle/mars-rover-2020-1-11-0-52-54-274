package com.thoughtworks.marsrover.model;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void add(Location location){
        this.x += location.getX();
        this.y += location.getY();
    }

    public void minus(Location location){
        this.x -= location.getX();
        this.y -= location.getY();
    }
}

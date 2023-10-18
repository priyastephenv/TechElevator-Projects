package com.techelevator.vehicle;

public class HotAirBalloon implements Drivable {
    @Override
    public void turn(String direction) {
        System.out.println("Hot Air Balloon turning " + direction);
    }

    @Override
    public boolean accelerate() {
        System.out.println("Hot Air Balloon accelerating...");
        return false;
    }

    @Override
    public boolean decelerate() {
        System.out.println("Hot Air Balloon decelerating...");
        return false;
    }
}

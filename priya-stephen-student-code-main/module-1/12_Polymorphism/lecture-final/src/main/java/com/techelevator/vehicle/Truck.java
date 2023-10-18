package com.techelevator.vehicle;

public class Truck extends Vehicle implements Drivable {

    @Override
    public void drive(){
        System.out.println("Truck driving...");
    }

    @Override
    public void turn(String direction) {
        System.out.println("Truck turning " + direction);
    }

    @Override
    public boolean accelerate() {
        System.out.println("Truck accelerating...");
        return false;
    }

    @Override
    public boolean decelerate() {
        System.out.println("Truck decelerating...");
        return false;
    }
}

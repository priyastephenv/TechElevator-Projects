package com.techelevator.vehicle;

public class Car extends Vehicle implements Drivable {

    @Override
    public void drive(){
        System.out.println("Car driving...");
    }

    @Override
    public void turn(String direction) {
        System.out.println("Car turning " + direction);
    }

    @Override
    public boolean accelerate() {
        System.out.println("Car accelerating");
        return false;
    }

    @Override
    public boolean decelerate() {
        System.out.println("Car decelerating");
        return false;
    }
}

package com.techelevator;

public class Elevator {

    // The current floor the elevator is on.
    private int currentFloor;

    // The number of floors available to the elevator.
    private int numberOfFloors;

    //Whether the elevator door is open or not.
    private boolean doorOpen;

    public Elevator(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.currentFloor = 1;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor() {

       doorOpen = true;

    }

    public void closeDoor(){

        doorOpen = false;

    }

    public void goUp (int desiredFloor) {

        if (!doorOpen && desiredFloor <=numberOfFloors && desiredFloor > this.currentFloor ){

            this.currentFloor = desiredFloor;
        }



    }

    public void goDown (int desiredFloor) {

        if (!doorOpen && desiredFloor <=numberOfFloors && desiredFloor > 0 && desiredFloor < this.currentFloor) {

            this.currentFloor = desiredFloor;
        }





    }








}

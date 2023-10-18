package com.techelevator.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    public static void main(String[] args) {

        /*
         * Vehicle List
         */

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add( new Vehicle() );
        vehicleList.add( new Car() );
        vehicleList.add( new Truck() );
        vehicleList.add( new Bicycle() );

        for( Vehicle eachVehicle : vehicleList ){
            eachVehicle.drive();
        }

        /*
         * Drivable list
         */

        List<Drivable> drivableList = new ArrayList<>();

        drivableList.add( new Car() );
        drivableList.add( new Truck() );
        drivableList.add( new HotAirBalloon() );

        // These things are not drivable
        //drivableList.add( new Bicycle() );
        //drivableList.add( new Vehicle() );

        // Interfaces can't be instantiated, i.e. no objects can be created
        //Drivable drivingThing = new Drivable();

        for(Drivable eachDrivableObject : drivableList){
            eachDrivableObject.turn("right");
            eachDrivableObject.accelerate();
            eachDrivableObject.decelerate();
            System.out.println();
        }
    }

}

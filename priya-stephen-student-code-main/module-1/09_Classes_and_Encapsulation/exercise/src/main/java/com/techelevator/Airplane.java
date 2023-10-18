package com.techelevator;

public class Airplane {

    private String planeNumber;
    private int totalFirstClassSeats;

    private int bookedFirstClassSeats;

    private int totalCoachSeats;
    private int bookedCoachSeats;

    public int getAvailableFirstClassSeats (){

        return (this.totalFirstClassSeats - this.bookedFirstClassSeats);
    }

    public int getAvailableCoachSeats (){

        return this.totalCoachSeats - this.bookedCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }



    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public boolean reserveSeats (boolean forFirstClass, int totalNumberOfSeats){

        if (forFirstClass) {

            if (totalNumberOfSeats <= getAvailableFirstClassSeats()) {
            bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
            return true;}

        } else {

            if (totalNumberOfSeats <= getAvailableCoachSeats()){
            bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
            return true;}
        }
        return false;
    }
    }




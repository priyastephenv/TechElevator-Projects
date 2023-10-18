package com.techelevator.service.model;

/*
 * Represents one of the 4 houses that get returned by
 * GET /Houses
 */
public class House {

    private String name;
    private String houseColours;
    private String founder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseColours() {
        return houseColours;
    }

    public void setHouseColours(String houseColours) {
        this.houseColours = houseColours;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }
}

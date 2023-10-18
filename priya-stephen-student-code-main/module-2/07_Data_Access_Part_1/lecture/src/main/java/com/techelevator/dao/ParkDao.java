package com.techelevator.dao;

import com.techelevator.model.Park;

import java.time.LocalDate;
import java.util.List;

public interface ParkDao {

    int getParkCount();

    LocalDate getOldestParkDate();

    double getAvgParkArea();

    List<String> getParkNames();

    Park getRandomPark();

    List<Park> getParksWithCamping();

    Park getParkById(int parkId);

    List<Park> getParksByState(String stateAbbreviation);

    List<Park> getParksByName(String name, boolean useWildCard);
}

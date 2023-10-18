package com.techelevator.dao;

import com.techelevator.model.Park;

import java.util.List;

public interface ParkDao {

    int getParkCount();

    List<String> getParkNames();

    Park getRandomPark();

    List<Park> getParksWithCamping();

    Park getParkById(int parkId);

    List<Park> getParksByState(String stateAbbreviation);

    Park createPark(Park park);

    Park updatePark(Park park);

    int deleteParkById(int parkId);

    void linkParkState(int parkId, String stateAbbreviation);
}

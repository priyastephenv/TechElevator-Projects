package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;

public interface CityDao {
    
    int getCityCount();

    int getMostPopulatedCity();

    int getLeastPopulatedCity();

    double getAvgCityArea();

    List<String> getCityNames();

    City getRandomCity();

    City getCityById(int cityId);

    List<City> getCitiesByState(String stateAbbreviation);
}

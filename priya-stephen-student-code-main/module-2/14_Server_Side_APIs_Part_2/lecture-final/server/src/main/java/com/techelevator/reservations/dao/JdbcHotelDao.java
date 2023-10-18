package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcHotelDao implements HotelDao{


    @Override
    public List<Hotel> getHotels() {
        return null;
    }

    @Override
    public List<Hotel> getHotelsByStateAndCity(String state, String city) {
        return null;
    }

    @Override
    public Hotel getHotelById(int id) {
        return null;
    }
}

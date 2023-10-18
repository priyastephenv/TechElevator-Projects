package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name="hotel.source", havingValue="database")
public class JdbcHotelDao implements HotelDao{


    JdbcTemplate jdbcTemplate;
    public JdbcHotelDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

    }
    @Override
    public List<Hotel> list() {
        String sql = "SELECT h.hotel_id, h.name, h.stars, h.rooms_available, " +
                "h.cost_per_night, h.cover_img, a.id AS address_id, a.address, a.city, a.state, a.zip from hotel h JOIN address a ON " +
                "h.address_id = a.id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Hotel> hotelList = new ArrayList<>();
        while (results.next()){
            Address address = mapRowToAddress(results);
            Hotel hotel = mapRowToHotel(results, address);
            hotelList.add(hotel);
        }
        return hotelList;
    }

    @Override
    public void create(Hotel hotel) {
        String sql = "INSERT INTO address (address, address2, city, state, zip) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING id";
        Address address = hotel.getAddress();
        Integer address_id = jdbcTemplate.queryForObject(sql, Integer.class,
                address.getAddress(), address.getAddress2(), address.getCity(),
                address.getState(), address.getZip());

        sql = "INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, " +
                "coverImage) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, hotel.getName(), address_id, hotel.getStars(),
                hotel.getRoomsAvailable(), hotel.getCostPerNight(), hotel.getCoverImage());

    }

    @Override
    public Hotel get(int id) {
        String sql = "SELECT h.hotel_id, h.name, h.stars, h.rooms_available, " +
                "h.cost_per_night, h.cover_img, a.id AS address_id, a.address, a.city, a.state, a.zip from hotel h JOIN address a ON " +
                "h.address_id = a.id WHERE h.hotel_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        Hotel hotel = null;
        while (results.next()){
            Address address = mapRowToAddress(results);
            hotel = mapRowToHotel(results, address);

        }
        return hotel;
    }

    private Address mapRowToAddress(SqlRowSet row){
        int addressId = row.getInt("address_id");
        Address address = new Address(""+addressId,
                row.getString("address"), null, row.getString("city"),
                row.getString("state"), row.getString("zip"));
        return address;
    }

    private Hotel mapRowToHotel(SqlRowSet row, Address address){
        return new Hotel(row.getInt("hotel_id"), row.getString("name"),
                address, row.getInt("stars"), row.getInt("rooms_available"),
                row.getDouble("cost_per_night"));
    }
}

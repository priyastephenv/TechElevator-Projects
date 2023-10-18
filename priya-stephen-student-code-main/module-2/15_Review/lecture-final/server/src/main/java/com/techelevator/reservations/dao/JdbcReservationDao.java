package com.techelevator.reservations.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.reservations.exception.DaoException;
import com.techelevator.reservations.model.Reservation;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name="reservation.source", havingValue="database")
public class JdbcReservationDao implements ReservationDao{

    JdbcTemplate jdbcTemplate;
    public JdbcReservationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }

    @Override
    public List<Reservation> findAll() {
        List<Reservation> reservationList = new ArrayList<>();
        String sql = "SELECT  reservation_id, hotel_id, full_name, checkin_date, " +
                "checkout_date, guests FROM reservation";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Reservation reservation = mapRowToReservation(results);
            reservationList.add(reservation);
        }
        return reservationList;
    }

    @Override
    public Reservation getSpecificReservation(int reservationID) {
        Reservation reservation = null;
        //TODO: Implement get to find a specific ID
        return reservation;
    }

    @Override
    public List<Reservation> findByHotel(int hotelID) {
        List<Reservation> reservationList = new ArrayList<>();
        //TODO: Implement findByHotel
        return reservationList;
    }

    @Override
    public Reservation createNewReservation(Reservation reservation, int hotelID) {
        Reservation newReservation = null;
        // TODO: implement create
        return newReservation;
    }

    @Override
    public Reservation updateReservation(Reservation reservation, int id) {
        // TODO: implement update
        return reservation;
    }

    @Override
    public void deleteReservation(int id) {

        String sql = "DELETE FROM reservation WHERE reservation_id = ?";

        try {
            /*
             * TODO: validate the delete by checking rows returned is exactly 1???
             */
            int rowsAffected = this.jdbcTemplate.update(sql, id);

            if(rowsAffected == 0){
                throw new DaoException("ERROR: 0 reservations deleted!");
            }

        } catch(DataIntegrityViolationException e){
            throw new DaoException("ERROR: Unable to delete reservation with id " + id, e);
        }
        // TODO: Add other catches for final/production version of code
    }

    private Reservation mapRowToReservation(SqlRowSet row){
        Reservation reservation = new Reservation(row.getInt("reservation_id"),
                row.getInt("hotel_id"), row.getString("full_name"),
                row.getString("checkin_date"), row.getString("checkout_date"),
                row.getInt("guests"));
        return reservation;
    }
}

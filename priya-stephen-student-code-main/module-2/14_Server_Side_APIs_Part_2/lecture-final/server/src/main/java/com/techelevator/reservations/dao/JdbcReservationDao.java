package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Reservation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReservationDao implements ReservationDao{

    @Override
    public List<Reservation> getReservations() {
        return null;
    }

    @Override
    public List<Reservation> getReservationsByHotel(int hotelId) {
        return null;
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        return null;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation, int reservationId) {
        return null;
    }

    @Override
    public int deleteReservationById(int id) {
        return 0;
    }
}

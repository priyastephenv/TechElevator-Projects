package com.techelevator.reservations.dao;

import java.util.List;

import com.techelevator.reservations.model.Reservation;

public interface ReservationDao {

    List<Reservation> findAll();

    Reservation getSpecificReservation(int reservationID);

    List<Reservation> findByHotel(int hotelID);

    Reservation createNewReservation(Reservation reservation, int hotelID);

    Reservation updateReservation(Reservation reservation, int id);

    void deleteReservation(int id);

}
package com.techelevator.reservations.controller;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController(HotelDao hotelDao,
                           ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        Hotel hotel = hotelDao.get(id);
        if (hotel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found.");
        } else {
            return hotel;
        }
    }

    /**
     * /hotels/filter?state=oh&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state,
                                            @RequestParam(required = false) String city) {

        /*
         * TODO: Should this logic be in this controller?
         */
        List<Hotel> filteredHotels = new ArrayList<>();
        List<Hotel> hotels = list();

        // return hotels that match state
        for (Hotel hotel : hotels) {

            // if city was passed we don't care about the state filter
            if (city != null) {
                if (hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
                    filteredHotels.add(hotel);
                }
            } else {
                if (hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
                    filteredHotels.add(hotel);
                }
            }
        }

        return filteredHotels;
    }
    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    // TODO: Accept GET request at /reservations"
    public List<Reservation> listReservations() {
        return new ArrayList<Reservation>();
    }

    /**
     * Get a reservation by its id
     *
     */
    // TODO: Accept GET request at /reservations/{id}"
    public Reservation getReservation() {
        return new Reservation();
    }

    /**
     * List of reservations by hotel
     *
     * @return all reservations for a given hotel
     */
    // TODO: Accept GET request at /hotels/{id}/reservations
    public List<Reservation> listReservationsByHotel() {
        return new ArrayList<Reservation>();
    }

    /**
     * Create a new reservation for a given hotel
     */
    // TODO: Accept POST request at /reservations
    //  Return a status of 204 created
    //  Expect a reservation to be sent in in JSON format
    public Reservation addReservation() {
        return new Reservation();
    }


    // TODO: Accept PUT request at /reservations/{id}
    //  Expect a reservation to be sent in in JSON format
    public Reservation updateReservation(){
        Reservation returnedReservation = new Reservation();
        return returnedReservation;
    }

    // TODO: Accept DELETE at /reservations/{id}
    //  Return NO CONTENT rather than a 200
    public void deleteReservation(@PathVariable int id){
    }


}

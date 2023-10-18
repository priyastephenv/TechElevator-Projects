package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // @Override - overriding an abstract/interface method
    //                      /hotels?state=Michigan&city="Detroit"
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list(@RequestParam(value = "state", required = false) String state,
                            @RequestParam(value = "city", required = false, defaultValue = "Detroit") String city)
    {

        // TODO: Use the state variable to filter out the hotels
        //  that match the state
        return hotelDao.getHotelsByStateAndCity(state, city);
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.getHotelById(id);
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations(){
        return reservationDao.getReservations();
    }

    /*
     * TODO: Create a method handler for the GET /reservations/id
     */
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET )
    public Reservation getReservationById(@PathVariable int id){
        return reservationDao.getReservationById(id);
    }

    /*
     * ERROR: duplicate mapping to GET /reservation/id
     */
//    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET )
//    public Reservation anotherGetReservationById(@PathVariable int id){
//        return reservationDao.getReservationById(id);
//    }

    /*
     * TODO: Create a method handler for the GET /hotels/id/reservations
     */
    @RequestMapping(path = "/hotels/{hotelId}/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservationsByHotelId(@PathVariable int hotelId,
                                                      @RequestParam(required = false, value = "name") String name)
    {
        // TODO: Add filter by name query parameter
        return reservationDao.getReservationsByHotel(hotelId);
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservationToAdd){

        Reservation createdReservation = reservationDao.createReservation(reservationToAdd);
        return createdReservation;
    }
}

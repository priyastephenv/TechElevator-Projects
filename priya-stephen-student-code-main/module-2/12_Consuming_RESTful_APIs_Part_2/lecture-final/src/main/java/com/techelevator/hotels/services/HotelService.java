package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import com.techelevator.util.BasicLoggerException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;



public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {

        /*
         * Setup request header to expected JSON data
         */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        /*
         * Make a request object to send to server
         * Includes request header AND request body (reservation object)
         */
        HttpEntity<Reservation> entity = new HttpEntity<>(newReservation, headers);

        /*
         * Send the request, get the response data
         */
        Reservation returnedReservation = null;

        try{
            final String url = API_BASE_URL + "reservations";
            returnedReservation = this.restTemplate.postForObject(url, entity, Reservation.class);
        } catch(RestClientResponseException e) {
            String errorMessage = "Returned status: " + e.getRawStatusCode() + "\n" +
                                  "Status Text: " + e.getStatusText();
            System.out.println(errorMessage);
            BasicLogger.log(errorMessage);
        } catch(ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
            BasicLogger.log(errorMessage);
        }

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        boolean updateSuccessful = false;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> entity = new HttpEntity<>(updatedReservation, headers);

        final String url = API_BASE_URL + "reservations/" + updatedReservation.getId();

        try {

            this.restTemplate.put(url, entity);
            updateSuccessful = true;

        } catch(RestClientResponseException e) {
            String errorMessage = "Returned status: " + e.getRawStatusCode() + "\n" +
                                  "Status Text: " + e.getStatusText();
            System.out.println(errorMessage);
            BasicLogger.log(errorMessage);
        } catch(ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
            BasicLogger.log(errorMessage);
        }

        // TODO: Add exception handling so true isn't always returned
        return updateSuccessful;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        boolean deleteSuccessful = false;
        final String url = API_BASE_URL + "reservations/" + id;

        try {

            this.restTemplate.delete(url);
            deleteSuccessful = true;

        } catch(RestClientResponseException e) {
            String errorMessage = "Returned status: " + e.getRawStatusCode() + "\n" +
                                  "Status Text: " + e.getStatusText();
            System.out.println(errorMessage);
            BasicLogger.log(errorMessage);

            /*
             * Alternatively, throw generic BasicLoggerException
             * instead of return status
             */
            //throw new BasicLoggerException(errorMessage);

        } catch(ResourceAccessException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
            BasicLogger.log(errorMessage);

            /*
             * Alternatively, throw generic BasicLoggerException
             * instead of return status
             */
            //throw new BasicLoggerException(errorMessage);
        }

        // TODO: Add exception handling so true isn't always returned
        return deleteSuccessful;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}

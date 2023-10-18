package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        Hotel[] returnedHotels = this.restTemplate.getForObject(API_BASE_URL + "hotels",
                                                                Hotel[].class);
        return returnedHotels;
    }

    public Review[] listReviews() {

        Review[] returnedReviews = this.restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);

        return returnedReviews;
    }

    public Hotel getHotelById(int id) {

        Hotel returnedHotel = this.restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);

        return returnedHotel;
    }

    public Review[] getReviewsByHotelId(int hotelId) {

        Review[] reviews = this.restTemplate.getForObject(API_BASE_URL + "reviews?hotelId=" + hotelId,
                                                          Review[].class);

        return reviews;
    }

    public Hotel[] getHotelsByStarRating(int stars) {

        Hotel[] hotels = this.restTemplate.getForObject(API_BASE_URL + "hotels?stars=" + stars,
                Hotel[].class);

        return hotels;
    }

    public City getWithCustomQuery(){

        String endpoint = "https://api.teleport.org/api/cities/geonameid:5391811/";
        City sd = this.restTemplate.getForObject(endpoint, City.class);

        return sd;
    }

}

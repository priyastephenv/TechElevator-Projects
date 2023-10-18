package com.techelevator.service;

import com.techelevator.service.model.House;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class RestWizardApi implements WizardApi {

    private final String BASE_URL = "https://wizard-world-api.herokuapp.com";
    private RestTemplate template;

    // TODO: Test to see if Spring can inject this dependency
    public RestWizardApi(){
        this.template = new RestTemplate();
    }

    /*
     * Base URL = https://wizard-world-api.herokuapp.com/
     * GET /Houses
     */
    public House getRandomHouse(){

        /*
         * TODO: Add try-catches to handle RestClientExceptions
         */
        // 1. Call api to get all the houses
        String url = BASE_URL + "/Houses";
        House[] houses = this.template.getForObject(url, House[].class);

        // Pick a random house, index 0 - 3
        int randomHouseIndex = new Random().nextInt(houses.length);
        House randomHouse = houses[randomHouseIndex];

        return randomHouse;
    }
}

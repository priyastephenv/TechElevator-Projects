package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

import java.io.IOException;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {

        /*
         * Setup request header to expected JSON data
         */

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        /*
         * Make a request object to send to server
         * Includes request header AND request body (reservation object)
         */
        HttpEntity<Auction> entity = new HttpEntity<>(newAuction, headers);

        /*
         * Send the request, get the response data
         */
        Auction returnedAuction = null;

        try{
            final String url = API_BASE_URL;
            returnedAuction= this.restTemplate.postForObject(url, entity, Auction.class);
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

        return returnedAuction;

    }

    public boolean update(Auction updatedAuction) {
        // place code here
        boolean updateSuccessful = false;

      HttpEntity entity = makeEntity(updatedAuction);

        final String url = API_BASE_URL + updatedAuction.getId();

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

        return updateSuccessful;
    }

    public boolean delete(int auctionId) {
        // place code here
        boolean deleteSuccessful = false;
        final String url = API_BASE_URL + auctionId;

        try {

            this.restTemplate.delete(url);
            deleteSuccessful = true;

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

        return deleteSuccessful;




    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}

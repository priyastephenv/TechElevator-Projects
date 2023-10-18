package com.techelevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CatCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatCardsApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }// was getting an error about beans"Consider defining a bean of type 'org.springframework.web.client.RestTemplate' in your configuration.".
    //Needs this for RestTemplate to be configured properly and allow the program to run and make http requests.
}

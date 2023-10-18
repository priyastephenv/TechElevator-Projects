package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {
 	private RestTemplate restTemplate;

	public RestCatFactService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public CatFact getFact() {
		try {//http request to get random cat fact from url below
			return restTemplate.getForObject("https://cat-data.netlify.app/api/facts/random", CatFact.class);
		} catch (Exception e) {//added exception handling, just in case it fails to get cat fact
			return new CatFact();
		}
	}
}

package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {
	private RestTemplate restTemplate;

	public RestCatPicService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public CatPic getPic() {
		try {//http request to get random cat pic from url below
			return restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
		} catch (Exception e) {//added exception in case it cant pull a cat pic
			return new CatPic();
		}
	}
}	

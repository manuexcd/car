package com.spring.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.car.model.Car;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String saveCar(Car car) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://carfilter/", car, String.class);
		
		return response.getBody();
	}
}

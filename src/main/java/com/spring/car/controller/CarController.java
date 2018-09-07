package com.spring.car.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.car.model.Car;
import com.spring.car.repository.CarRepository;
import com.spring.car.service.CarService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
	
	@GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Car> getAllCars() {
		return carRepository.findAll().delayElements(Duration.ofMillis(500));
	}
	
	@GetMapping(path="/color/{color}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Car> getCarsByColor(@PathVariable String color) {
		return carRepository.findByColor(color).delayElements(Duration.ofMillis(500));
	}
	
	@GetMapping(path="/brand/{brand}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Car> getCarsByBrand(@PathVariable String brand) {
		return carRepository.findByBrand(brand).delayElements(Duration.ofMillis(500));
	}
	
	@PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Mono<Car> addCar(@RequestBody Car car) {
		Mono<Car> mono = carRepository.save(car);
		mono.subscribe(carService::saveCar);
		return mono;
	}
	
	@DeleteMapping
	public Mono<Void> deleteAllCars() {
		return carRepository.deleteAll();
	}
}
package com.spring.car.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.spring.car.model.Car;

import reactor.core.publisher.Flux;

public interface CarRepository extends ReactiveCrudRepository<Car, ObjectId> {
	Flux<Car> findByColor(String color);
	
	Flux<Car> findByBrand(String brand);
}

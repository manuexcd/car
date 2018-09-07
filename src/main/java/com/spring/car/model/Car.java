package com.spring.car.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "cars")
public class Car {
	@Id
	@ToString.Exclude
	@JsonIgnore
	private ObjectId id;
	@Indexed
	@NonNull
	private String brand;
	@Indexed
	@NonNull
	private String model;
	@Indexed
	@NonNull
	private String color;
}

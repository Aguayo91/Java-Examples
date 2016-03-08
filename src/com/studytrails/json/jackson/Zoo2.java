package com.studytrails.json.jackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "@class")
public class Zoo2 {

	public String name;
	public String city;
	public List<Animal2> animals;

	@JsonCreator
	public Zoo2(@JsonProperty("name") String name, @JsonProperty("city") String city) {
		this.name = name;
		this.city = city;
	}

	public void setAnimals(List<Animal2> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "Zoo2 [name=" + name + ", city=" + city + ", animals=" + animals + "]";
	}

}

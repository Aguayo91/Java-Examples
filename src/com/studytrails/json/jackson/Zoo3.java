package com.studytrails.json.jackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "@class")
public class Zoo3 {

	public String name;
	public String city;
	public List<Animal4> animals;

	@JsonCreator
	public Zoo3(@JsonProperty("name") String name, @JsonProperty("city") String city) {
		this.name = name;
		this.city = city;
	}

	public void setAnimals(List<Animal4> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "Zoo [name=" + name + ", city=" + city + ", animals=" + animals + "]";
	}

}

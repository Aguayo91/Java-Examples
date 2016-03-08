package com.studytrails.json.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeZoo {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Zoo4 zoo = new Zoo4("London Zoo", "London");
		Lion lion = new Lion("Simba");
		Elephant elephant = new Elephant("Manny");
		zoo.addAnimal4(elephant).add(lion);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, zoo);
	}
}

class Zoo4 {
	public String name;
	public String city;

	@JsonCreator
	public Zoo4(@JsonProperty("name") String name, @JsonProperty("city") String city) {
		this.name = name;
		this.city = city;
	}

	public List<Animal4> Animal4s = new ArrayList<Animal4>();

	public List<Animal4> addAnimal4(Animal4 Animal4) {
		Animal4s.add(Animal4);
		return Animal4s;
	}

	@Override
	public String toString() {
		return "Zoo [name=" + name + ", city=" + city + ", Animal4s=" + Animal4s + "]";
	}

}

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = Lion3.class, name = "lion"), @Type(value = Elephant3.class, name = "elephant") })
abstract class Animal4 {
	public String name;
}

class Elephant extends Animal4 {

	@JsonCreator
	public Elephant(@JsonProperty("name") String name) {
		super.name = name;
	}

	@Override
	public String toString() {
		return "Elephant : " + name;
	}
}

class Lion extends Animal4 {
	@JsonCreator
	public Lion(@JsonProperty("name") String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Lion: " + name;
	}
}

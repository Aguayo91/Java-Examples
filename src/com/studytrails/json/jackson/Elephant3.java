package com.studytrails.json.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Elephant3 extends Animal3 {

	@JsonProperty
	private String name;

	@JsonCreator
	public Elephant3(@JsonProperty("name") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return "trumpet";
	}

	public String getType() {
		return "herbivorous";
	}

	public boolean isEndangered() {
		return false;
	}

	@Override
	public String toString() {
		return "Elephant [name=" + name + ", getName()=" + getName() + ", getSound()=" + getSound() + ", getType()=" + getType()
				+ ", isEndangered()=" + isEndangered() + "]";
	}

}

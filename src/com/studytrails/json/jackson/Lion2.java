package com.studytrails.json.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lion2 extends Animal2 {

	private String name;

	@JsonCreator
	public Lion2(@JsonProperty("name") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return "Roar";
	}

	public String getType() {
		return "carnivorous";
	}

	public boolean isEndangered() {
		return true;
	}

	@Override
	public String toString() {
		return "Lion2 [name=" + name + ", getName()=" + getName() + ", getSound()=" + getSound() + ", getType()=" + getType() + ", isEndangered()="
				+ isEndangered() + "]";
	}

}

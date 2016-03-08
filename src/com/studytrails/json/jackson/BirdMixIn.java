package com.studytrails.json.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BirdMixIn {
	BirdMixIn(@JsonProperty("name") String name) {
	};

	@JsonProperty("sound")
	abstract String getSound();

	@JsonProperty("habitat")
	abstract String getHabitat();
}

package com.studytrails.json.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = Lion2.class, name = "lion"), @Type(value = Elephant2.class, name = "elephant") })
public abstract class Animal2 {
	@JsonProperty("name")
	String name;
	@JsonProperty("sound")
	String sound;
	@JsonProperty("type")
	String type;
	@JsonProperty("endangered")
	boolean endangered;

}

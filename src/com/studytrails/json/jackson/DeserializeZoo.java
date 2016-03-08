package com.studytrails.json.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeZoo {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"name\":\"London Zoo\",\"city\":\"London\",\"animals\":[{\"@class\":\"com.studytrails.json.jackson.Elephant\",\"name\":\"Manny\"},{\"@class\":\"com.studytrails.json.jackson.Lion\",\"name\":\"Simba\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.readValue(json, Zoo3.class));
	}
}

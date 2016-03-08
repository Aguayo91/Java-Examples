package com.studytrails.json.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeAnimals {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		List<Animal3> animals = new ArrayList<Animal3>();
		Lion3 lion = new Lion3("Samba");
		Elephant3 elephant = new Elephant3("Manny");
		animals.add(lion);
		animals.add(elephant);
		ObjectMapper mapper = new ObjectMapper();

		mapper.writerWithType(new TypeReference<List<Animal3>>() {
		}).writeValue(System.out, animals);
	}
}

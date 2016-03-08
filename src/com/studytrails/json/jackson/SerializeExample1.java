package com.studytrails.json.jackson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeExample1 {
	private static String outputFile = "zoo.json";

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// let start creating the zoo
		Zoo2 zoo = new Zoo2("Samba Wild Park", "Paz");
		Lion2 lion = new Lion2("Simba");
		Elephant2 elephant = new Elephant2("Manny");
		List<Animal2> animals = new ArrayList<>();
		animals.add(lion);
		animals.add(elephant);
		zoo.setAnimals(animals);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(new File(outputFile)), zoo);
	}
}

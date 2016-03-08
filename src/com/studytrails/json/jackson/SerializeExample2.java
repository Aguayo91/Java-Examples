package com.studytrails.json.jackson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeExample2 {
	private static String outputFile = "zoo2.json";

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// let start creating the zoo
		Lion2 lion = new Lion2("Simba");
		Elephant2 elephant = new Elephant2("Manny");
		List<Animal2> animals = new ArrayList<>();
		animals.add(lion);
		animals.add(elephant);

		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writerWithType(new TypeReference<List<Animal2>>() {
		}).writeValueAsString(animals);
		IOUtils.write(s, new FileOutputStream(new File(outputFile)));
	}
}

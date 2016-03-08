package com.studytrails.json.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeSerializeExample2 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Animal2> animals = mapper.readValue(FileUtils.readFileToByteArray(new File("zoo2.json")), new TypeReference<List<Animal2>>() {
		});
		System.out.println(animals);
	}
}

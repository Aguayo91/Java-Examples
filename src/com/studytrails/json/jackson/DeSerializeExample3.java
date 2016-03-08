package com.studytrails.json.jackson;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeSerializeExample3 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixInAnnotations(Bird.class, BirdMixIn.class);
		Bird bird = mapper.readValue(FileUtils.readFileToByteArray(new File("bird.json")), Bird.class);
		System.out.println(bird);
	}
}

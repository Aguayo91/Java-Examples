package com.studytrails.json.jackson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

public class BuildJson {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		JsonFactory factory = new JsonFactory();
		JsonGenerator generator = factory.createGenerator(new FileOutputStream("albums2.json"));
		generator.setPrettyPrinter(new DefaultPrettyPrinter());
		generator.writeStartObject();

		generator.writeStringField("album_name", "pop hits");
		generator.writeStringField("album_id", "1234");
		generator.writeArrayFieldStart("tags");
		generator.writeString("pop");
		generator.writeString("old");
		generator.writeEndArray();
		generator.writeEndObject();
		generator.close();
	}

}

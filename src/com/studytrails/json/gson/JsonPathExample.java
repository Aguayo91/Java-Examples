package com.studytrails.json.gson;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class JsonPathExample {
	public static void main(String[] args) throws MalformedURLException, IOException {
		String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=1";
		String json = IOUtils.toString(new URL(url));
		JsonReader reader = new JsonReader(new StringReader(json));
		System.out.println(reader.getPath());
		handleObject(reader);
	}

	private static void handleObject(JsonReader reader) throws IOException {
		reader.beginObject();
		while (reader.hasNext()) {
			JsonToken token = reader.peek();
			if (token.equals(JsonToken.BEGIN_ARRAY))
				handleArray(reader);
			else if (token.equals(JsonToken.END_ARRAY)) {
				reader.endObject();
				return;
			} else
				handleNonArrayToken(reader, token);
		}

	}

	public static void handleArray(JsonReader reader) throws IOException {
		reader.beginArray();
		while (true) {
			JsonToken token = reader.peek();
			if (token.equals(JsonToken.END_ARRAY)) {
				reader.endArray();
				break;
			} else if (token.equals(JsonToken.BEGIN_OBJECT)) {
				handleObject(reader);
			} else
				handleNonArrayToken(reader, token);
		}
	}

	public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException {
		 if (token.equals(JsonToken.STRING)) {
			System.out.println(reader.getPath());
			reader.skipValue();
		}  else
			reader.skipValue();
	}
}

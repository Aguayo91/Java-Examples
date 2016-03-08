package com.studytrails.json.gson;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class SerializeGsonBuilderExample3 {
	public static void main(String[] args) throws JsonSyntaxException, MalformedURLException, IOException {
		GsonBuilder builder = new GsonBuilder();
		builder.setFieldNamingStrategy(new FieldNamingStrategy() {

			@Override
			public String translateName(Field f) {
				return "_" + f.getName();
			}
		}).setPrettyPrinting().serializeNulls();

		Gson gson = builder.create();
		Album albums = new Album();
		albums.setTitle("Example");
		Dataset dataset = new Dataset();
		dataset.setAlbum_title("album1");
		albums.setDataset(new Dataset[] { dataset });
		System.out.println(gson.toJson(albums));

	}
}

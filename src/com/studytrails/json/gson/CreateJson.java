package com.studytrails.json.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateJson {

	public static void main(String[] args) {
		// create the albums object
		JsonObject albums = new JsonObject();
		// add a property calle title to the albums object
		albums.addProperty("title", "album1");

		// create an array called datasets
		JsonArray datasets = new JsonArray();

		// create a dataset
		JsonObject dataset = new JsonObject();
		// add the property album_id to the dataset
		dataset.addProperty("album_id", 1);
		// add the property album_year to the dataset
		dataset.addProperty("album_year", 1996);

		datasets.add(dataset);

		albums.add("dataset", datasets);

		// create the gson using the GsonBuilder. Set pretty printing on. Allow
		// serializing null and set all fields to the Upper Camel Case
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		System.out.println(gson.toJson(albums));
		/* prints
		{
			  "title": "album1",
			  "dataset": [
			    {
			      "album_id": 1,
			      "album_year": 1996
			    }
			  ]
		}
		*/
	}
}

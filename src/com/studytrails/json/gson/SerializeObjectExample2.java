package com.studytrails.json.gson;

import com.google.gson.Gson;

/**
 * Example Demonstrating java serialization to json. The example tries to create
 * a subset of json at
 * http://freemusicarchive.org/api/get/albums.json?api_key=60
 * BLHNQCAOUFPIBZ&limit=5 The Albums2 object contains a list of Dataset2 objects.
 * Each Dataset2 object is an album
 * 
 */
public class SerializeObjectExample2 {
	public static void main(String[] args) {

		Album albums = new Album();
		albums.setTitle("Example");
		Dataset dataset = new Dataset();
		dataset.setAlbum_title("album1");
		albums.setDataset(new Dataset[] { dataset });
		// create the gson object
		Gson gson = new Gson();
		// use the gson objected created to convert albums to json
		// representation
		System.out.println(gson.toJson(albums));
		// prints
		// {"title":"Example","dataset":[{"album_title":"album1","otherProperties":{}}]}
	}
}

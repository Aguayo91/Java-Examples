package com.studytrails.json.gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DatasetTypeAdapterExample8 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=5";
		String json = IOUtils.toString(new URL(url));
		// Create the custom type adapter and register it with the GsonBuilder
		// class.
		Gson gson = new GsonBuilder().registerTypeAdapter(Dataset.class, new DatasetTypeAdapter()).create();
		// deserialize the json to Albums2 class. The Dataset2 objects are part of
		// the Albums2 class. Whenever Gson encounters an object of type DataSet
		// it calls the DatasetTypeAdapter to read and write json.
		Album albums = gson.fromJson(json, Album.class);
		System.out.println(albums.getDataset()[1].getAlbum_title());
		// prints
		// http://freemusicarchive.org/music/The_Yes_Sirs/Through_The_Cracks_Mix_Vol_1/
	}
}

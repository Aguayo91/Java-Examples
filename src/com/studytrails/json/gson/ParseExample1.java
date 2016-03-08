package com.studytrails.json.gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class ParseExample1 {
	public static void main(String[] args) throws JsonSyntaxException, MalformedURLException, IOException {
		// Get a list of albums from free music archive. limit the results to 5
		String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=5";
		Gson gson = new Gson();
		GsonBuilder builder = new GsonBuilder();
		Album albums = gson.fromJson(IOUtils.toString(new URL(url)), Album.class);
		System.out.println(albums.getTitle());
		Dataset[] datasets = albums.getDataset();
		for (Dataset dataset : datasets) {
			System.out.println(dataset.getAlbum_title());
		}
	}
}

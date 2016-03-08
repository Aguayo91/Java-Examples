package com.studytrails.json.orgjson;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToCsv {
	public static void main(String[] args) {
		String url = "http://freemusicarchive.org/api/get/genres.json?api_key=60BLHNQCAOUFPIBZ&limit=10";
		try {
			String genreJson = IOUtils.toString(new URL(url));
			JSONObject json = new JSONObject(genreJson);
			System.out.println(CDL.toString(new JSONArray(json.get("dataset").toString())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

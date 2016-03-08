package com.studytrails.json.jsonsimple;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class BuildJson1 {

	public static void main(String[] args) {
		JSONObject dataset = new JSONObject();
		dataset.put("genre_id", 1);
		dataset.put("genre_parent_id", null);
		dataset.put("genre_title", "International");
		dataset.put("genre_handle", "International");
		dataset.put("genre_color", "#CC3300");
		System.out.println(dataset.toJSONString());
		// if you want to escape characters
		System.out.println(JSONValue.escape(dataset.toJSONString()));
	}

}

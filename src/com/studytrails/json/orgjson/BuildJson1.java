package com.studytrails.json.orgjson;

import org.json.JSONObject;

public class BuildJson1 {

	public static void main(String[] args) {
		JSONObject dataset = new JSONObject();
		dataset.put("genre_id", 1);
		dataset.put("genre_parent_id", JSONObject.NULL);
		dataset.put("genre_title", "International");
		// use the accumulate function to add to an existing value. The value
		// will now be converted to a list
		dataset.accumulate("genre_title", "Pop");
		// append to the key
		dataset.append("genre_title", "slow");
		dataset.put("genre_handle", "International");
		dataset.put("genre_color", "#CC3300");

		// get the json array for a string
		System.out.println(dataset.getJSONArray("genre_title"));
		// prints ["International","Pop","slow"]

		// increment a number by 1
		dataset.increment("genre_id");

		// quote a string allowing the json to be delivered within html
		System.out.println(JSONObject.quote(dataset.toString()));
		// prints
		// "{\"genre_color\":\"#CC3300\",\"genre_title\":[\"International\",\"Pop\",\"slow\"],
		// \"genre_handle\":\"International\",\"genre_parent_id\":null,\"genre_id\":2}"
	}

}

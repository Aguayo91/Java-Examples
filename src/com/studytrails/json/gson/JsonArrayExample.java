package com.studytrails.json.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonArrayExample {
	public static void main(String[] args) {

		JsonArray array = new JsonArray();
		array.add(new JsonPrimitive("StringA"));
		JsonObject a = new JsonObject();
		a.add("key1", new JsonPrimitive("value1"));
		JsonObject b = new JsonObject();
		b.add("key2", new JsonPrimitive("value2"));
		array.add(a);
		System.out.println(array.toString());
		// prints ["StringA",{"key1":"value1"}]

		// the new methods now
		System.out.println(array.contains(a));// prints true
		System.out.println(array.contains(b));// prints false
		array.set(1, b);
		System.out.println(array.toString());
		// prints ["StringA",{"key2":"value2"}]. the value at index 1 is
		// overwritten
		System.out.println(array.remove(a)); // prints false since a is not
												// present in the array
		System.out.println(array.remove(1));
		// prints {"key2":"value2"}, the element that is removed
		System.out.println(array.toString());
		//prints ["StringA"]

	}
}

package com.studytrails.json.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Groups1 {
	private static String testString1 = "{\"name\":\"joe user\",\"favorite_color\":\"42\",contact:[]}";
	private static String testString2 = "{\"name\":\"joe user\",\"favorite_color\":\"42\",contact:{\"street\":\"1234 Main St\",\"city\":\"New York\"}}";

	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(testString1);
		System.out.println(createUser(element));
		JsonElement element2 = parser.parse(testString2);
		System.out.println(createUser(element2));
	}

	private static User createUser(JsonElement element) {
		User user = new User();
		JsonObject userObj = element.getAsJsonObject();
		user.setName(userObj.get("name").getAsString());
		user.setFavorite_color(userObj.get("favorite_color").getAsString());
		JsonElement contact = userObj.get("contact");
		if (contact.isJsonArray())
			user.setContact(null);
		else
			user.setContact(createContact(contact));
		return user;

	}

	private static Contact createContact(JsonElement contact1) {
		Contact contact = new Contact();
		JsonObject contactObj = contact1.getAsJsonObject();
		contact.setStreet(contactObj.get("street").getAsString());
		contact.setCity(contactObj.get("city").getAsString());

		return contact;
	}

	static class User {
		private String name;
		private String favorite_color;
		private Contact contact;

		public void setName(String name) {
			this.name = name;
		}

		public void setFavorite_color(String favorite_color) {
			this.favorite_color = favorite_color;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", favorite_color=" + favorite_color + ", contact=" + contact + "]";
		}

	}

	static class Contact {
		private String street;
		private String city;

		public void setStreet(String street) {
			this.street = street;
		}

		public void setCity(String city) {
			this.city = city;
		}

		@Override
		public String toString() {
			return "Contact [street=" + street + ", city=" + city + "]";
		}

	}
}

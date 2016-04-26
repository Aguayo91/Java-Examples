package com.studytrails.patterns.java.observer;

public class Client {

	public static void main(String[] args) {
		PropertyAgent agent = new PropertyAgent();

		Renter renter1 = new Renter("renter1");
		agent.addObserver(renter1);

		CorporateRenter renter2 = new CorporateRenter("corpRenter2");
		agent.addObserver(renter2);

		Property property1 = new Property("house1", "2");
		agent.addProperties(property1);

		Property property2 = new Property("house2", "2");
		agent.addProperties(property2);
		
		agent.removeProperty(property1);
		agent.removeProperty(property2);

	}
}

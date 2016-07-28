package com.studytrails.patterns.java.observer;

public class Client {

	private static PropertyAgent agent;
	private static Renter renter1;
	private static Property property1;
	private static Property property2;
	private static CorporateRenter renter2;

	public static void main(String[] args) {
		agent = new PropertyAgent();

		renter1 = new Renter("renter1");
		agent.addObserver(renter1);

		renter2 = new CorporateRenter("corpRenter2");
		agent.addObserver(renter2);

		property1 = new Property("house1", "2");
		agent.addProperties(property1);

		property2 = new Property("house2", "2");
		agent.addProperties(property2);

		agent.removeProperty(property1);
		agent.removeProperty(property2);

	}
}

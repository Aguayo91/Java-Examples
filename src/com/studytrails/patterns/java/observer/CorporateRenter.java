package com.studytrails.patterns.java.observer;

import java.util.Observable;
import java.util.Observer;

public class CorporateRenter implements Observer {

	String name;

	public CorporateRenter(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		Property property = (Property) arg;
		System.out.println(
				"Corporate Renter " + name + " notified about " + property.status + " property " + property.name);
	}

}

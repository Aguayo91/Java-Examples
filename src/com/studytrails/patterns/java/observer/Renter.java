package com.studytrails.patterns.java.observer;

import java.util.Observable;
import java.util.Observer;

public class Renter implements Observer {

	String name;

	public Renter(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		Property property = (Property) arg;
		System.out.println(name + " notified about " + property.status + " property " + property.name);
	}

}

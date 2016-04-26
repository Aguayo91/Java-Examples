package com.studytrails.patterns.java.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PropertyAgent extends Observable {

	List<Property> properties = new ArrayList<>();

	public void addProperties(Property property) {
		properties.add(property);
		setChanged();
		notifyObservers(property);

	}

	public void removeProperty(Property property) {
		property.status = "removed";
		if (properties.remove(property))
			setChanged();
		notifyObservers(property);
	}
}

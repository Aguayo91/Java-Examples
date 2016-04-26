package com.studytrails.patterns.java.observer;

public class Property {

	String name;
	String noOfBeds;
	String status;

	public Property(String name, String noOfBeds) {
		this.name = name;
		this.noOfBeds = noOfBeds;
		this.status = "added";
	}
}

package com.studytrails.patterns.decorator;

public abstract class Profile
{
	String name;
	String email;
	String currentEducation;
	String highestEducation;
	String currentCompany;
	int experience;

	public abstract void printProfile();
}

package com.studytrails.patterns.decorator;

public class StudentProfile extends Profile
{

	public StudentProfile(String name, String email, String currentEducation)
	{
		this.name = name;
		this.email = email;
		this.currentEducation = currentEducation;
	}

	@Override
	public void printProfile()
	{
		System.out.println(name + "," + email + "," + currentEducation);
	}

}

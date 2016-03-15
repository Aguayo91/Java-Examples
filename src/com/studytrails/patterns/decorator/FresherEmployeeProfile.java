package com.studytrails.patterns.decorator;

public class FresherEmployeeProfile extends Profile
{

	public FresherEmployeeProfile(String name, String email, String highestEducation,
			String currentCompany)
	{
		this.name = name;
		this.email = email;
		this.highestEducation = highestEducation;
		this.currentCompany = currentCompany;
	}

	@Override
	public void printProfile()
	{
		System.out.println(name + "," + email + "," + highestEducation + "," + currentCompany);

	}

}

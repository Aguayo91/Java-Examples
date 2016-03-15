package com.studytrails.patterns.decorator;

public class SeniorEmployeeProfile extends Profile
{

	public SeniorEmployeeProfile(String name, String email, String highestEducation,
			int experience, String currentCompany)
	{
		this.name = name;
		this.email = email;
		this.highestEducation = highestEducation;
		this.experience = experience;
		this.currentCompany = currentCompany;
	}

	@Override
	public void printProfile()
	{
		System.out.println(name + "," + email + "," + highestEducation + "," + experience + ","
				+ currentCompany);
	}

}

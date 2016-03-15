package com.studytrails.patterns.decorator;

public class CollegeInfoProfilePrinterDecorator extends ProfilePrinter
{
	Profile profile;

	public CollegeInfoProfilePrinterDecorator(Profile profile)
	{
		this.profile = profile;
	}

	@Override
	public void printProfile()
	{
		profile.printProfile();
		// get college information from college directory
		if (profile.currentEducation != null)
			System.out.println("Enhanced info for " + profile.currentEducation);
	}
}

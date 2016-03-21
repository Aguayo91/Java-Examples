package com.studytrails.patterns.decorator;

public class CompanyInfoProfilePrinterDecorator extends ProfilePrinter
{


	public CompanyInfoProfilePrinterDecorator(Profile profile)
	{
		this.profile = profile;
	}

	@Override
	public void printProfile()
	{
		profile.printProfile();
		// get company information from company directory
		if (profile.currentCompany != null)
			System.out.println("Enhanced info for " + profile.currentCompany);
	}

}

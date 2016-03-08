package com.studytrails.patterns.adapter;

public class AmericanSocketAdapteeImpl implements AmericanSocketAdaptee
{

	@Override
	public void provideElectricity(AmericanPinType americanPin)
	{
		System.out.println("Enjoy Electricity");
	}

}

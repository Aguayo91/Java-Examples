package com.studytrails.patterns.abstract_factory;

public class MazdaCarFactory extends CarFactory
{
	@Override
	public Insurance getInsurance(String name)
	{
		return new CompleteInsurance(name);
	}
	@Override
	public Maintenance getMaintenance(String name)
	{
		return new ComprehensiveMaintenance(name);
	}
	@Override
	public Car getCar(String name)
	{
		return new Mazda(name);
	}
}

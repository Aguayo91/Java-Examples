package com.studytrails.patterns.abstract_factory;

public class FerrariCarFactory extends CarFactory
{
	@Override
	public Insurance getInsurance(String name)
	{
		return new PartialInsurance(name);
	}
	@Override
	public Maintenance getMaintenance(String name)
	{
		return new BasicMaintenance(name);
	}
	@Override
	public Car getCar(String name)
	{
		return new Ferrari(name);
	}
}

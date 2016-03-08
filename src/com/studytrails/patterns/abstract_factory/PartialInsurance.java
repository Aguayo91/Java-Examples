package com.studytrails.patterns.abstract_factory;

public class PartialInsurance implements Insurance
{
	String name;
	public PartialInsurance(String name)
	{
		this.name = name;
	}
	@Override
	public String getName()
	{
		return name;
	}
}

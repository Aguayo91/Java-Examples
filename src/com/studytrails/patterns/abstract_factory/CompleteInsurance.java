package com.studytrails.patterns.abstract_factory;

public class CompleteInsurance implements Insurance
{
	String name;
	public CompleteInsurance(String name)
	{
		this.name = name;
	}
	@Override
	public String getName()
	{
		return name;
	}
}

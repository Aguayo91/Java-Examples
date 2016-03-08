package com.studytrails.patterns.java.prototype;

public class CompleteInsurance implements Insurance
{
	String name;
	public CompleteInsurance(String name)
	{
		this.name = name;
	}
	public void setName(String name)
	{
		this.name = name;

	}
	public Insurance clone() throws CloneNotSupportedException
	{
		CompleteInsurance insurance = (CompleteInsurance) super.clone();
		insurance.setName(this.name);
		return insurance;
	}
}

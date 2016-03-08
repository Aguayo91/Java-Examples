package com.studytrails.patterns.java.prototype;

public class PartialInsurance implements Insurance
{
	String name;
	public PartialInsurance(String name)
	{
		this.name = name;
	}
	public void setName(String name)
	{
		this.name = name;

	}
	public Insurance clone() throws CloneNotSupportedException
	{
		PartialInsurance insurance = (PartialInsurance) super.clone();
		insurance.setName(this.name);
		return insurance;
	}
}

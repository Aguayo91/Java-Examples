package com.studytrails.patterns.java.strategy;

public class Car
{

	private String manufacturer;
	private String engineType;
	private String enginePlacement;
	private String bodyConfiguration;
	private String make;

	public Car(String make)
	{
		this.make = make;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public String getEngineType()
	{
		return engineType;
	}

	public void setEngineType(String engineType)
	{
		this.engineType = engineType;
	}

	public String getEnginePlacement()
	{
		return enginePlacement;
	}

	public void setEnginePlacement(String enginePlacement)
	{
		this.enginePlacement = enginePlacement;
	}

	public String getBodyConfiguration()
	{
		return bodyConfiguration;
	}

	public void setBodyConfiguration(String bodyConfiguration)
	{
		this.bodyConfiguration = bodyConfiguration;
	}

	public String getMake()
	{
		return make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}

}

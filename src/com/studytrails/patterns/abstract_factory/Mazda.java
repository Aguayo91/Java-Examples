package com.studytrails.patterns.abstract_factory;

public class Mazda implements Car
{

	private String name;
	private Maintenance maintenance;
	private Insurance insurance;

	public Mazda(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setInsurance(Insurance insurance)
	{
		this.insurance = insurance;

	}

	public void setMaintenance(Maintenance maintenance)
	{
		this.maintenance = maintenance;

	}

	public Insurance getInsurance()
	{
		return insurance;
	}

	public Maintenance getMaintenance()
	{
		return maintenance;
	}

}


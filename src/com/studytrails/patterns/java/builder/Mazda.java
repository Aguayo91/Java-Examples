package com.studytrails.patterns.java.builder;

public class Mazda implements Car
{
	private String name;
	private Maintenance maintenance;
	private Insurance insurance;
	private EngineType engineType;
	private BodyType bodyType;
	public Mazda(String name)
	{
		this.name = name;
	}
	public void setInsurance(Insurance insurance)
	{
		this.insurance = insurance;
	}
	public void setMaintenance(Maintenance maintenance)
	{
		this.maintenance = maintenance;
	}
	public void setBodyType(BodyType bodyType)
	{
		this.bodyType = bodyType;
	}
	public void setEngineType(EngineType engineType)
	{
		this.engineType = engineType;
	}
}

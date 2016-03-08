package com.studytrails.patterns.java.builder;

public interface Car
{
	public void setInsurance(Insurance insurance);
	public void setMaintenance(Maintenance maintenance);
	public void setBodyType(BodyType bodyType);
	public void setEngineType(EngineType engineType);
}

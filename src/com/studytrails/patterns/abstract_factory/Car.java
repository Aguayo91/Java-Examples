package com.studytrails.patterns.abstract_factory;

public interface Car
{
	public String getName();

	public void setInsurance(Insurance insurance);

	public Insurance getInsurance();

	public void setMaintenance(Maintenance maintenance);

	public Maintenance getMaintenance();
}

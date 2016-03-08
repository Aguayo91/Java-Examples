package com.studytrails.patterns.java.prototype;

public class ComprehensiveMaintenance implements Maintenance
{
	String name;
	public ComprehensiveMaintenance(String name)
	{
		this.name = name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Maintenance clone() throws CloneNotSupportedException
	{
		ComprehensiveMaintenance maintenance = (ComprehensiveMaintenance) super.clone();
		maintenance.setName(this.name);
		return maintenance;
	}
}

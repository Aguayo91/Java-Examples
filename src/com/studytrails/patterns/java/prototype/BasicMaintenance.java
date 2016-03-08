package com.studytrails.patterns.java.prototype;

public class BasicMaintenance implements Maintenance
{
	String name;
	public BasicMaintenance(String name)
	{
		this.name = name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Maintenance clone() throws CloneNotSupportedException
	{
		BasicMaintenance maintenance = (BasicMaintenance) super.clone();
		maintenance.setName(this.name);
		return maintenance;
	}
}

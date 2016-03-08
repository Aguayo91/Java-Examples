package com.studytrails.patterns.java.prototype;

public interface Maintenance extends Cloneable
{
	public void setName(String name);
	public Maintenance clone() throws CloneNotSupportedException;
}

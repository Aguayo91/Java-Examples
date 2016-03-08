package com.studytrails.patterns.java.prototype;
public interface Insurance 
{
	public void setName(String name);
	public Insurance clone() throws CloneNotSupportedException;
}

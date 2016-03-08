package com.studytrails.patterns.java.prototype;

public class FourWheelDrive implements DriveType
{
	public DriveType clone() throws CloneNotSupportedException
	{
		return (DriveType) super.clone();
	}
}

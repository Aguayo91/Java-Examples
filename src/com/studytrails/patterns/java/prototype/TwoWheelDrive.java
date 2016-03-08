package com.studytrails.patterns.java.prototype;

public class TwoWheelDrive implements DriveType
{
	public DriveType clone() throws CloneNotSupportedException
	{
		return (DriveType) super.clone();
	}
}

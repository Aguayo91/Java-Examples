package com.studytrails.patterns.java.factory_method;

import java.awt.Color;

public class Ferrari implements Car
{
	private String name;
	private Color color;

	public Ferrari(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return color;
	}
}

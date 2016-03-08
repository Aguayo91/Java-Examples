package com.studytrails.patterns.java.factory_method;

import java.awt.Color;

public class CarBuilder
{

	public Ferrari buildFerrari(String name)
	{
		return new Ferrari(name);
	}

	public Mazda buildMazda(String name)
	{
		return new Mazda(name);
	}

	public void paintMazda(Mazda mazda, Color color)
	{
		mazda.setColor(color);
	}

	public void paintFerrari(Ferrari ferrari, Color color)
	{
		ferrari.setColor(color);
	}
}

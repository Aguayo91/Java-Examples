package com.studytrails.patterns.java.builder;

public interface CarBuilder
{
	public Car buildCar();
	public Car buildCarParameterized(String... initializers);
}

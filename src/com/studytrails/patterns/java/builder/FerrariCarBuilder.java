package com.studytrails.patterns.java.builder;

public class FerrariCarBuilder implements CarBuilder
{
	@Override
	public Car buildCar()
	{
		Ferrari ferrari = new Ferrari("ferrari");
		ferrari.setBodyType(new Convertible("Conv1"));
		ferrari.setEngineType(new V4("v4"));
		ferrari.setMaintenance(new BasicMaintenance("basic"));
		ferrari.setInsurance(new CompleteInsurance("insA"));
		return ferrari;
	}
	@Override
	public Car buildCarParameterized(String... initializers)
	{
		return null;
	}
}

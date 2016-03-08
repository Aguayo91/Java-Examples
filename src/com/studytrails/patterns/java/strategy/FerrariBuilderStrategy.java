package com.studytrails.patterns.java.strategy;

public class FerrariBuilderStrategy implements CarBuilderStrategy
{

	@Override
	public Car buildCar(String make)
	{
		Car car = new Car(make);
		car.setBodyConfiguration("convertible");
		car.setEnginePlacement("front-engine, rear wheel drive");
		car.setEngineType("V8");
		car.setManufacturer("Ferrari");
		return car;
	}
}

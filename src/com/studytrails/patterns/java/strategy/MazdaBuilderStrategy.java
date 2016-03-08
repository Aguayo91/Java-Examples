package com.studytrails.patterns.java.strategy;

public class MazdaBuilderStrategy implements CarBuilderStrategy
{

	@Override
	public Car buildCar(String make)
	{
		Car car = new Car(make);
		car.setBodyConfiguration("sedan");
		car.setEnginePlacement("front");
		car.setEngineType("SkyActiv-G");
		car.setManufacturer("Mazda");
		return car;
	}

}

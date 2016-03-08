package com.studytrails.patterns.java.strategy;

public class CarBuilderClient
{

	private CarBuilderStrategy strategy;

	public static void main(String[] args)
	{
		CarBuilderClient client = new CarBuilderClient();
		client.setStategy(new MazdaBuilderStrategy());
		Car mazda = client.buildCar("mazda6-sport");
		client.setStategy(new FerrariBuilderStrategy());
		Car ferrari = client.buildCar("ferrari-california");

	}

	public void setStategy(CarBuilderStrategy stategy)
	{
		this.strategy = stategy;
	}

	public Car buildCar(String make)
	{
		return strategy.buildCar(make);
	}
}

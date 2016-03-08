package com.studytrails.patterns.java.builder;

public class CarBuilderClient
{
	static CarBuilder builder;
	static Car car;
	public static void main(String[] args)
	{
		CarBuilderClient client = new CarBuilderClient();
		builder = new FerrariCarBuilder();
		client.buildCar(builder);
		builder = new MazdaCarBuilder();
		client.buildCarParameterized(builder, "bodyType-sedan-mazdasedan", "engineType-V4-mazdav4");
	}
	private void buildCar(CarBuilder builder)
	{
		car = builder.buildCar();
	}
	private void buildCarParameterized(CarBuilder builder, String... parameters)
	{
		builder.buildCarParameterized(parameters);
	}
}

package com.studytrails.patterns.abstract_factory;

public class Client
{
	CarFactory factory;
	public static void main(String[] args)
	{
		Client client = new Client();
		client.setFactory(new MazdaCarFactory());
		client.buildCar("mazda", "Insurance1", "Maintenance1");
	}
	private void buildCar(String name, String insuranceName, String maintenanceName)
	{
		Car car = factory.getCar(name);
		car.setInsurance(factory.getInsurance(insuranceName));
		car.setMaintenance(factory.getMaintenance(maintenanceName));
	}
	public void setFactory(CarFactory factory)
	{
		this.factory = factory;
	}
}

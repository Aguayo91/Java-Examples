package com.studytrails.patterns.java.prototype;

public class Client
{
	PrototypeManager manager;
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Client client = new Client();
		client.buildCar();
	}
	public void buildCar() throws CloneNotSupportedException
	{
		manager = new PrototypeManager();
		FordVehicle fordFiesta = manager.getVehicle("fordCar");
		FordVehicle fordMustang = manager.getVehicle("fordCar");
		FordVehicle fordEscape = manager.getVehicle("fordSUV");
		FordVehicle fordExplorer = manager.getVehicle("fordSUV");
	}
}

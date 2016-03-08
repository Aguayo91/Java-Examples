package com.studytrails.patterns.java.prototype;

public class ClientBasic
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		ClientBasic client = new ClientBasic();
		client.buildCar();
	}
	private void buildCar()
	{
		// cars
		FordVehicle fordFiesta = new FordVehicle();
		fordFiesta.setDriveType(new TwoWheelDrive());
		fordFiesta.setInsurance(new PartialInsurance("partialInsurance"));
		fordFiesta.setMaintenance(new BasicMaintenance("basicMaintenance"));

		FordVehicle fordMustang = new FordVehicle();
		fordMustang.setDriveType(new TwoWheelDrive());
		fordMustang.setInsurance(new PartialInsurance("partialInsurance"));
		fordMustang.setMaintenance(new BasicMaintenance("basicMaintenance"));

		// SUVs
		FordVehicle fordEscape = new FordVehicle();
		fordEscape.setDriveType(new FourWheelDrive());
		fordEscape.setInsurance(new CompleteInsurance("completeInsurance"));
		fordEscape.setMaintenance(new ComprehensiveMaintenance("comprehensiveMaintenance"));

		FordVehicle fordExplorer = new FordVehicle();
		fordExplorer.setDriveType(new FourWheelDrive());
		fordExplorer.setInsurance(new CompleteInsurance("completeInsurance"));
		fordExplorer.setMaintenance(new ComprehensiveMaintenance("comprehensiveMaintenance"));
	}
}

package com.studytrails.patterns.java.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager
{
	private Insurance partialInsurance;
	private Insurance completeInsurance;
	private Maintenance basicMaintenance;
	private Maintenance comprehensiveMaintenance;
	private DriveType twoWheelDrive;
	private DriveType fourWheelDrive;
	private Map<String, FordVehicle> fordRegistry = new HashMap<String, FordVehicle>();
	public PrototypeManager()
	{
		initialize();
		initializeVehicles();
	}
	private void initialize()
	{
		partialInsurance = new PartialInsurance("partialInsurance");
		completeInsurance = new CompleteInsurance("completeInsurance");
		basicMaintenance = new BasicMaintenance("basicMaintenance");
		comprehensiveMaintenance = new ComprehensiveMaintenance("comprehensiveMaintenance");
		twoWheelDrive = new TwoWheelDrive();
		fourWheelDrive = new FourWheelDrive();
	}
	private void initializeVehicles()
	{
		FordVehicle fordCar = new FordVehicle();
		fordCar.setDriveType(twoWheelDrive);
		fordCar.setInsurance(partialInsurance);
		fordCar.setMaintenance(basicMaintenance);
		fordRegistry.put("fordCar", fordCar);

		FordVehicle fordSUV = new FordVehicle();
		fordSUV.setDriveType(fourWheelDrive);
		fordSUV.setInsurance(completeInsurance);
		fordSUV.setMaintenance(comprehensiveMaintenance);
		fordRegistry.put("fordSUV", fordSUV);
	}
	public void addVehicle(String key, FordVehicle vehicle){
		fordRegistry.put(key, vehicle);
	}
	public FordVehicle getVehicle(String key) throws CloneNotSupportedException
	{
		FordVehicle vehicle = fordRegistry.get(key);
		return vehicle.clone();
	}
}

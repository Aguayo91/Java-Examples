package com.studytrails.patterns.java.prototype;
public class FordVehicle
{
	Insurance insurance;
	Maintenance maintenance;
	DriveType driveType;
	public void setInsurance(Insurance insurance)
	{
		this.insurance = insurance;
	}
	public void setMaintenance(Maintenance maintenance)
	{
		this.maintenance = maintenance;
	}
	public void setDriveType(DriveType driveType)
	{
		this.driveType = driveType;
	}
	public FordVehicle clone() throws CloneNotSupportedException
	{
		FordVehicle vehicle = (FordVehicle) super.clone();
		vehicle.setInsurance(insurance.clone());
		vehicle.setMaintenance(maintenance.clone());
		vehicle.setDriveType(driveType.clone());
		return vehicle;
	}
}

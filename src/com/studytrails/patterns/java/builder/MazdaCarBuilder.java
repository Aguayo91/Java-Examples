package com.studytrails.patterns.java.builder;

public class MazdaCarBuilder implements CarBuilder
{
	@Override
	public Car buildCar()
	{
		Mazda mazda = new Mazda("mazda");
		mazda.setBodyType(new Sedan("sedan"));
		mazda.setEngineType(new V6("v6"));
		mazda.setMaintenance(new ComprehensiveMaintenance("compA"));
		mazda.setInsurance(new PartialInsurance("insB"));
		return mazda;
	}
	/**
	 * This method shows a partially implemented build method that uses
	 * parameters to build objects
	 * 
	 * @param initializers
	 * @return
	 */
	public Car buildCarParameterized(String... initializers)
	{
		Mazda mazda = new Mazda("mazda");
		for (String initializer : initializers) {
			String[] tokens = initializer.split("-");
			if (tokens[0].equals("bodyType")) {
				if (tokens[1].equals("sedan"))
					mazda.setBodyType(new Sedan(tokens[2]));
				else if (tokens[1].equals("convertible"))
					mazda.setBodyType(new Convertible(tokens[2]));
			} else if (tokens[0].equals("engineType")) {
				// code for engine type
			}
			// code for maintenance and insurance
		}
		return mazda;
	}
}

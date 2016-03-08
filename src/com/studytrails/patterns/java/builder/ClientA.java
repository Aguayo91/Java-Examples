package com.studytrails.patterns.java.builder;

public class ClientA
{
	public static void main(String[] args)
	{
		ClientA client = new ClientA();
		client.buildFerrari();
		client.buildMazda();
	}

	private void buildFerrari()
	{
		Ferrari ferrari = new Ferrari("ferrari");
		ferrari.setBodyType(new Convertible("Conv1"));
		ferrari.setEngineType(new V4("v4"));
		ferrari.setMaintenance(new BasicMaintenance("basic"));
		ferrari.setInsurance(new CompleteInsurance("insA"));

	}

	private void buildMazda()
	{
		Mazda mazda = new Mazda("mazda");
		mazda.setBodyType(new Sedan("sedan"));
		mazda.setEngineType(new V6("v6"));
		mazda.setMaintenance(new ComprehensiveMaintenance("compA"));
		mazda.setInsurance(new PartialInsurance("insB"));
	}

}

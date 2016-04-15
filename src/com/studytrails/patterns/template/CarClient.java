package com.studytrails.patterns.template;

public class CarClient {

	private static CarManufacturingAlgorithm carAlgorithmVariant1 = new CarManufacturingAlgorithmVariant1();
	private static CarManufacturingAlgorithmWithHooks carAlgorithmVariant2 = new CarManufacturingAlgorithmVariant2();

	public static void main(String[] args) {
		carAlgorithmVariant1.buildCar();
		carAlgorithmVariant2.buildCar();

	}
}

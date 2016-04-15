package com.studytrails.patterns.template;

public abstract class CarManufacturingAlgorithm {

	public void buildCar() {
		buildChasis();
		buildEngine();
		buildBody();
		addFeatures();
	}

	private void buildChasis() {
		// build chasis
	}

	private void buildEngine() {
		// build engine
	}

	private void buildBody() {
		// buildbody
	}

	abstract void addFeatures();

}

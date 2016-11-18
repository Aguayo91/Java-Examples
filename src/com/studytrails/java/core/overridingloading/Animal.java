package com.studytrails.java.core.overridingloading;

public class Animal {

	// METHOD 1
	public double getPopulation() {
		return 100;
	}

	//METHOD 2
	// This does not work since there is already a method with the same name.
	// Changing the return type does not help.
	/*-
	 public String getPopulation() {
		return "";
	}
	*/

	//METHOD 3
	// This does not work since there is already a method with the same name.
	// Adding an Exception to the method signature does not change that.
	/*-
	public double getPopulation() throws Exception {
		return 100;
	}
	*/

	//METHOD 4
	// This does not work since there is already a method with the same name.
	// Changing the method to static does not help.
	/*-
	public static void getPopulation(String country){
	}
	*/
	
	//METHOD 5
	// This works since although the names are same, the parameters are different
	public int getPopulation(String country) {
		return 1000;
	}

	//METHOD 6
	public int getPopulation(int countryCode) {
		return 1000;
	}

	//METHOD 7
	public int getPopulation(Number number) {
		return 1000;
	}

	//METHOD 8
	public int getPopulation(Double number) {
		return 1000;
	}

	//METHOD 9
	public void getPopulation(String country, String state) {

	}

	//METHOD 10
	public void getPopulation(String... parameters) {

	}

}

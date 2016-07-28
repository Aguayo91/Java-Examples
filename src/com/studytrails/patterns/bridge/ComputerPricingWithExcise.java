package com.studytrails.patterns.bridge;

/**
 * We need a quote for a price of a computer with applicable excise duty.
 */
public class ComputerPricingWithExcise extends ComputerPricing {

	/**
	 * This would delegate to the parent class which just uses the behaviour
	 * from the implementation class.
	 */
	public double getPrice() {
		return getPrice() + getExcise();
	}

}

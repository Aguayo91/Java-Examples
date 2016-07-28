package com.studytrails.patterns.bridge;

/**
 * We need a quote for a price of a computer with applicable excise duty.
 */
public class ComputerPricingWithCustoms extends ComputerPricing {
	@Override
	public double getPrice() {
		return getPrice() + getCustoms();
	}
}

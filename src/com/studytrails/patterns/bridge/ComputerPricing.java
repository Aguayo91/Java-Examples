package com.studytrails.patterns.bridge;

/**
 *
 * The top class of the abstraction hierarchy. This class has a reference to the
 * actual implementation and hence stores the 'bridge'. It defines methods that
 * delegate behaviour to the actual implementation class.
 *
 */
public class ComputerPricing {
	ComputerPricingImpl computerPricingImpl;

	public double getPrice() {
		return computerPricingImpl.getBaseRate() + computerPricingImpl.getShippingRate();

	}

	public double getExcise() {
		return computerPricingImpl.getExciseRate();
	}

	public double getCustoms() {
		return computerPricingImpl.getCustomsRate();
	}
}

package com.studytrails.patterns.bridge;

/**
 * This is an implementation class for US. It determines the pricing model for
 * US and also calculates the excise and customs. Note that it might delegate
 * actual processing to other private methods such as calculateExcise.
 *
 */
public class ComputerPricingImplUS extends ComputerPricingImpl {
	@Override
	public double getBaseRate() {
		return 1000;
	}

	@Override
	public double getCustomsRate() {
		return 0;
	}

	@Override
	public double getExciseRate() {
		return calculateExcise();
	}

	@Override
	public double getShippingRate() {
		return 3;
	}

	private double calculateExcise() {
		return 11;
	}
}

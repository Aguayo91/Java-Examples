package com.studytrails.patterns.bridge;

/**
 * This is an implementation class for AU. It determines the pricing model for
 * AU and also calculates the excise and customs. Note that it might delegate
 * actual processing to other private methods such as calculateCustoms.
 *
 */
public class ComputerPricingImplAU extends ComputerPricingImpl {
	@Override
	public double getBaseRate() {
		return 1000;
	}

	@Override
	public double getCustomsRate() {
		return calculateCustoms();
	}

	@Override
	public double getExciseRate() {
		return 0;
	}

	@Override
	public double getShippingRate() {
		return 3;
	}

	private double calculateCustoms() {
		return 9;
	}
}

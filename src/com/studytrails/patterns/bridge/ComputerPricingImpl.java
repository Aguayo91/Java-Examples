package com.studytrails.patterns.bridge;

/**
 * The top of the implementation hierarchy. The concrete classes would implement
 * the base rate, shipping rate, excise rate and customs rate.
 *
 */
public abstract class ComputerPricingImpl {
	public abstract double getBaseRate();

	public abstract double getShippingRate();

	public abstract double getExciseRate();

	public abstract double getCustomsRate();

}

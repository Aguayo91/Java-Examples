package com.studytrails.java.core.packages.bignumbers;

public class Addition {

	public static void main(String[] args) {
		Addition summer = new Addition();
		System.out.println(summer.add(args[1], args[2]));
	}

	public double add(String x, String y) {
		return Double.parseDouble(x) + Double.parseDouble(y);
	}
}

package com.studytrails.java8;

import java.util.Hashtable;

public class HashTableExample
{

	public static void main(String[] args)
	{
		HashTableExample example = new HashTableExample();
		example.runExample();
	}

	private void runExample()
	{
		Hashtable<String, String> countryCapital = new Hashtable<>();
		countryCapital.put("USA", "WashingtonDC");
		countryCapital.put("Japan", null);
		System.out.println(countryCapital);
	}
}

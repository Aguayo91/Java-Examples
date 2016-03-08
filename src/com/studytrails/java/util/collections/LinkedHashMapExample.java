package com.studytrails.java.util.collections;

import java.util.LinkedHashMap;

public class LinkedHashMapExample
{
	public static void main(String[] args)
	{
		LinkedHashMapExample example = new LinkedHashMapExample();
		example.runExample();
	}

	private void runExample()
	{
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("C", "c");
		linkedHashMap.put("A", "a");
		linkedHashMap.put("B", "b");
		linkedHashMap.put("AnotherA", "somea");
		System.out.println(linkedHashMap);// {C=c, A=a, B=b, AnotherA=somea}
		System.out.println(linkedHashMap.clone());// {C=c, A=a, B=b,
													// AnotherA=somea}
		

	}
}

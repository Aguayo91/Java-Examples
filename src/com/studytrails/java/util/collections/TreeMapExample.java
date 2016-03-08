package com.studytrails.java.util.collections;

import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample
{
	public static void main(String[] args)
	{
		TreeMapExample example = new TreeMapExample();
		example.runExample();
	}

	private void runExample()
	{
		TreeMap<String, String> treemap = new TreeMap<String, String>();
		treemap.put("C", "c");
		treemap.put("A", "a");
		treemap.put("B", "b");
		treemap.put("AnotherA", "somea");
		System.out.println(treemap);// {A=a, AnotherA=somea, B=b, C=c}
		// greatest key greater than or equal to
		System.out.println(treemap.ceilingKey("0")); // A
		System.out.println(treemap.ceilingEntry("0"));// A=a
		NavigableSet<String> keys = treemap.descendingKeySet();
		for (String key : keys) {
			System.out.println(key);// C B AnotherA A
		}
		System.out.println(treemap.firstEntry());// A=a
		// greatest key less than or equal to
		System.out.println(treemap.floorEntry("D"));// C=c
		SortedMap<String, String> sortedHeadTree = treemap.headMap("C");
		System.out.println(sortedHeadTree);// {A=a, AnotherA=somea, B=b}
		// least entry greater than or equal to
		System.out.println(treemap.higherEntry("A"));// AnotherA=somea
		System.out.println(treemap.navigableKeySet());// [A, AnotherA, B, C]
		System.out.println(treemap.pollFirstEntry());// A=a
		System.out.println(treemap);// {AnotherA=somea, B=b, C=c}
		System.out.println(treemap.subMap("AnotherA", "C"));// {AnotherA=somea,
															// B=b}

	}
}

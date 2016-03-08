package com.studytrails.java.util.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample
{
	public static void main(String[] args)
	{
		LinkedHashSetExample example = new LinkedHashSetExample();
		example.runExample();

	}

	private void runExample()
	{
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		// adds an element if not present
		linkedHashSet.add("A");
		linkedHashSet.addAll(Arrays.asList("C", "B", "G", "F"));
		System.out.println(linkedHashSet);// [A, C, B, G, F]
		// get an iterator. The iterator returns the elements in insertion order
		Iterator<String> iterator = linkedHashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// clone method maintains the order
		System.out.println(linkedHashSet.clone());// [A, C, B, G, F]
		// retains elements specified in this list
		linkedHashSet.retainAll(Arrays.asList("A", "A", "C"));
		System.out.println(linkedHashSet);// [A, C]

	}
}

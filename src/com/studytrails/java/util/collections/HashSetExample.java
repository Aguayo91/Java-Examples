package com.studytrails.java.util.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample
{

	public static void main(String[] args)
	{
		HashSetExample example = new HashSetExample();
		example.runExample();
	}

	private void runExample()
	{

		HashSet<Integer> set = new HashSet<Integer>();
		// adds the element to the set
		System.out.println(set.add(2)); // true
		System.out.println(set);// [2]
		// we cant add the same element again since set cannot contain
		// duplicates. method returns false and the
		// element is not added
		System.out.println(set.add(2));// false
		System.out.println(set); // [2]
		// we can add multiple elements, duplicate elements are ignored
		System.out.println(set.addAll(Arrays.asList(new Integer(1), new Integer(2))));
		// the order is not specified
		System.out.println(set);// [1, 2]
		// checks whether the set contains an element. note the primitive int is
		// autoboxed to Integer
		System.out.println(set.contains(1)); // true
		// size of the set
		System.out.println(set.size()); // 2
		// iterate over the set. The order is not specified
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}

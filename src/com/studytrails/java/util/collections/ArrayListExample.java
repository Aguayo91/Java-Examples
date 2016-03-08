package com.studytrails.java.util.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample
{

	public static void main(String[] args)
	{
		ArrayListExample example = new ArrayListExample();
		example.runExample();
	}

	private void runExample()
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		// appends elements to end of list
		arrayList.add("A");
		System.out.println(arrayList);// [A]
		// inserts element at the specified position shifting elements right
		arrayList.add(0, "0");
		// appends all elements of another Collection
		arrayList.addAll(Arrays.asList("B", "C"));
		System.out.println(arrayList);// [0, A, B, C]
		// return the element at a specific index
		System.out.println(arrayList.get(2)); // B
		// returns the index of the first occurence of the specified element
		System.out.println(arrayList.indexOf("C"));// 3
		// removes the element at a specified index.
		// returns that element
		System.out.println(arrayList.remove(0)); // 0
		// removes the first occurence of specified element from the list
		System.out.println(arrayList.remove("A"));// true
		System.out.println(arrayList);// [B, C]
		// adding null is allowed
		arrayList.add(null);
		System.out.println(arrayList);// [B, C, null]
		// multiple nulls are allowed
		arrayList.add(null);
		System.out.println(arrayList);// [B, C, null, null]
		// remove both nulls
		arrayList.remove(null);
		System.out.println(arrayList);// [B, C]
		// convert the arraylist to array of string
		arrayList.toArray(new String[0]);
		// clears the list
		arrayList.clear();
		System.out.println(arrayList);// []
	}
}

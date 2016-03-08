package com.studytrails.java.util.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Vector;

public class VectorExample
{
	public static void main(String[] args)
	{
		VectorExample example = new VectorExample();
		example.runVectorExample();
	}

	public void runVectorExample()
	{

		Vector<String> vector = new Vector<String>();
		System.out.println(vector.capacity()); // 10
		// sets capacity to specified
		vector.ensureCapacity(20);
		System.out.println(vector.capacity());
		// add an element
		vector.add("B");
		System.out.println(vector);// [B]
		// add the element at a particular index, shifting elements
		vector.add(0, "A");
		System.out.println(vector);// [A, B]
		// add all elements in the given collection
		vector.addAll(Arrays.asList("C", "D"));
		System.out.println(vector);// [A, B, C, D]
		// add element to end
		vector.addElement("E");
		System.out.println(vector);// [A, B, C, D, E]
		// returns true if vector contains the element
		vector.contains("A"); // true
		String[] a = new String[7];
		// copies the elements of the vector into the array
		vector.copyInto(a);
		System.out.println(Arrays.toString(a));// [A, B, C, D, E, null, null]
		// get element at an index. same as get(1)
		System.out.println(vector.elementAt(1)); // B
		System.out.println(vector.get(1));
		// return an enumeration of all elements.
		Enumeration<String> vectorElements = vector.elements();
		// iterate over all elemetns
		while (vectorElements.hasMoreElements()) {
			System.out.print(vectorElements.nextElement());
		}
		// ABCDE
		// get a sublist
		System.out.println(vector.subList(0, 2));// [A, B]
		// sort elements by specifying an order using the comparator interface
		vector.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2)
			{

				// sort in reverse order of normal String lexicographic order
				return -o1.compareTo(o2);
			}
		});
		System.out.println(vector);// [E, D, C, B, A]
	}
}

package com.studytrails.java.util.collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetExample
{

	public static void main(String[] args)
	{
		TreeSetExample example = new TreeSetExample();
		example.runExample();
	}

	private void runExample()
	{

		// elements are ordered using their natural order
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("C");
		System.out.println(treeSet);// [C]
		treeSet.add("A");// [A, C]
		System.out.println(treeSet);
		treeSet.add("D");
		// return the least element greater than or equal to this element
		System.out.println(treeSet.ceiling("B"));// C
		// an iterator in descending order
		Iterator<String> descIterator = treeSet.descendingIterator();
		while (descIterator.hasNext()) {
			System.out.print(descIterator.next()); // DCA
		}
		// get a set in descending order
		NavigableSet<String> navigableDescSet = treeSet.descendingSet();
		System.out.println(navigableDescSet); // [D, C, A]
		// get the first element
		System.out.println(treeSet.first());// A
		// greatest element less than or equal to this element
		System.out.println(treeSet.floor("K"));// D
		// a view of the set less than this element
		SortedSet<String> headSet = treeSet.headSet("D");
		System.out.println(headSet);// [A, C]
		// elements modified in the head set are reflected in the original set
		// since this is a view
		headSet.remove("A");
		System.out.println(headSet);// [C]
		System.out.println(treeSet);// [C, D]
		// there is a similar tailSet method.

		// returns an element strictly less than this element
		System.out.println(treeSet.lower("D")); // C
		System.out.println(treeSet.floor("D")); // D
	}
}

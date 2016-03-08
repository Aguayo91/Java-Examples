package com.studytrails.java.util.collections;

import java.util.Collection;
import java.util.Enumeration;
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
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("A", "a");
		hashTable.put("B", "b");
		System.out.println(hashTable);// {A=a, B=b}
		// hashTable.put(null, null); null not allowed
		System.out.println(hashTable.containsKey("A")); // true
		Enumeration<String> elements = hashTable.elements();
		while (elements.hasMoreElements()) {
			System.out.println(elements.nextElement());// a b
		}
		hashTable.remove("B", "c");
		System.out.println(hashTable);// {A=a, B=b}
		hashTable.remove("B", "b");
		System.out.println(hashTable);// {A=a}
		Collection<String> values = hashTable.values();
		System.out.println(values);// [a]

	}

}

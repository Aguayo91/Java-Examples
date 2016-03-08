package com.studytrails.java.util.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExample {

	public static void main(String[] args) {
		LinkedListExample example = new LinkedListExample();
		example.showListMethods();
		example.showLinkedListMethods();
	}

	private void showListMethods() {
		List<String> list = new LinkedList<String>();
		list.add("String1");
		System.out.println(list);// [String1]

		list.add(0, "string0.5");
		System.out.println(list);// [string0.5, String1]
		list.addAll(Arrays.asList(new String[] { "String2" }));
		System.out.println(list); // [string0.5, String1, String2]
		list.addAll(2,
				Arrays.asList(new String[] { "String1.5", "String1.75" }));
		System.out.println(list); // [string0.5, String1, String1.5, String1.75,
									// String2]
		System.out.println(list.contains("String1")); // true
		System.out.println(list.get(0)); // string0.5
		System.out.println(list.indexOf("String1.75"));// 3
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
		// string0.5 String1 String1.5 String1.75 String2
		System.out.println(list.remove(1)); // String1
		System.out.println(list);// [string0.5, String1.5, String1.75, String2]
		list.set(1, "NewString");
		System.out.println(list);// [string0.5, NewString, String1.75, String2]
		System.out.println(list.subList(0, 2)); // [string0.5, NewString]
		System.out.println(list.toArray(new String[0])[0]); // string0.5
		System.out.println(list.size()); // 4
		list.clear();
		System.out.println(list);// []
	}

	private void showLinkedListMethods() {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addAll(Arrays.asList("A", "B", "C"));
		System.out.println(linkedList); // [A, B, C]
		Iterator<String> iterator = linkedList.descendingIterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next());
		}
        // CBA
		System.out.println(linkedList.element()); // A
		System.out.println(linkedList); // [A, B, C]
		System.out.println(linkedList.getFirst()); // A
		System.out.println(linkedList.getLast()); // C
		linkedList.offer("D");
		System.out.println(linkedList); // [A, B, C, D]
		linkedList.offerFirst("-");
		System.out.println(linkedList); // [-, A, B, C, D]
		System.out.println(linkedList.peek()); // -
		System.out.println(linkedList.peekLast()); // D
		System.out.println(linkedList.poll()); // -
		System.out.println(linkedList); // [A, B, C, D]
		System.out.println(linkedList.pollLast()); // D
		System.out.println(linkedList); // [A, B, C]
		System.out.println(linkedList.pop()); // A
		System.out.println(linkedList); // [B, C]
		linkedList.push("A");
		System.out.println(linkedList); // [A, B, C]
		System.out.println(linkedList.removeFirst()); // A
		System.out.println(linkedList); // [B, C]
	}

}

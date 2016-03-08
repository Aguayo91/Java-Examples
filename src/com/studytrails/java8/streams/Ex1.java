package com.studytrails.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex1 {

	public static void main(String[] args) {
		List<Double> temperature = new ArrayList<Double>(Arrays.asList(new Double[] { 20.0, 22.0, 22.5 }));
		System.out.println(temperature.getClass());
		// temperature.forEach(s -> System.out.println(s));
		// temperature.forEach(System.out::println);
		// temperature.forEach(s -> System.out.println(Math.sqrt(s)));
		// temperature.removeIf(s -> s > 22.0);// remove elements that are > 22
		// temperature.replaceAll(s -> Math.pow(s, 0.5));
		// temperature.sort((a, b) -> a > b ? -1 : 1);

		Map<String, Integer> authorBooks = new HashMap<String, Integer>();
		authorBooks.put("Robert Ludlum", 27);
		authorBooks.put("Clive Cussler", 50);
		authorBooks.put("Tom Clancy", 17);
		// authorBooks.forEach((a, b) -> System.out.println(a + " wrote " + b +
		// " books"));
		// authorBooks.compute("Agatha Christie", (a, b) -> a.length());
		// authorBooks.compute("Tom Clancy", (a, b) -> b + 1);
		// authorBooks.computeIfAbsent("Agatha Christie", b -> b.length());
		// authorBooks.computeIfPresent("Tom Clancy", (a, b) -> b + 1);
		// System.out.println(authorBooks.get("Agatha Christie"));
		// System.out.println(authorBooks.getOrDefault("AuthorA", 0));
		// authorBooks.merge("AuthorB", 1, (a, b) -> a + b);
		// System.out.println(authorBooks.get("AuthorB"));
		// authorBooks.merge("AuthorB", 1, (a, b) -> a + b);
//		// System.out.println(authorBooks.get("AuthorB"));
//		System.out.println(authorBooks.putIfAbsent("AuthorC", 2));//null
//		System.out.println(authorBooks.putIfAbsent("AuthorC", 2));//2
		
//		authorBooks.replaceAll((a,b)->a.length()+b);
//		System.out.println(authorBooks);
		// System.out.println(authorBooks);
	}

}

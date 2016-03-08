package com.studytrails.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Ex2 {

	public static void main(String[] args) {
		List<String> genre = new ArrayList<String>(Arrays.asList("rock", "pop", "jazz", "reggae", "pop"));

		Map<String, List<String>> artists = new HashMap<String, List<String>>();
		artists.put("rock", new ArrayList<String>(Arrays.asList("rockArtistA", "rockArtistB")));
		artists.put("pop", new ArrayList<String>(Arrays.asList("popArtistA", "popArtistB")));
		artists.put("jazz", new ArrayList<String>(Arrays.asList("jazzArtistA", "jazzArtistB")));
		artists.put("reggae", new ArrayList<String>(Arrays.asList("reggaeArtistA", "reggaerockArtistB")));

		long a = genre.stream().filter(s -> s.startsWith("r")).count();
		// System.out.println(genre);
		// String[] ar = new String[] { "a", "b", "c" };
		// System.out.println(genre.stream().allMatch(s -> !s.isEmpty()));
		// System.out.println(genre.stream().peek(s->System.out.println(s)).anyMatch(s
		// -> s.indexOf("r") == 0));
		// System.out.println(genre);
		// System.out.println(genre.stream().peek(s->System.out.println(s)).count());
		// System.out.println(genre.stream().count());
		// System.out.println(genre.stream().distinct().count());
		// System.out.println(genre.stream().count());
		// System.out.println(genre.stream().filter(s -> s.length() <=
		// 4).count());
		// genre.stream().forEach(System.out::println);
		// Optional<String> combinedgenre = genre.stream().reduce((b, c) ->
		// b.concat(",").concat(c));
		// int d = genre.stream().reduce(0, (b, c) -> b + c.length(), (b, c) ->
		// b + c);
		// System.out.println(d);
		// HashSet<String> genreSet = genre.stream().collect(() -> new
		// HashSet<String>(), (b, c) -> b.add(c), (b, c) -> b.addAll(c));
		// genre.stream().ma
		// System.out.println(genreSet);
		// HashSet<String> set = new HashSet<String>();
		// set.a
		// System.out.println(combinedgenre.get());
		// System.out.println(genre);
		// genre.stream().map(String::toUpperCase).forEach(System.out::println);

		genre.stream().flatMap(s -> artists.get(s).stream()).forEach(s -> System.out.print(" " + s));
		// prints rockArtistA rockArtistB popArtistA popArtistB jazzArtistA jazzArtistB
		//reggaeArtistA reggaerockArtistB popArtistA popArtistB

	}
}

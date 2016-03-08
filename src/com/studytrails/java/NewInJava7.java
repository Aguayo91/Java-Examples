package com.studytrails.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NewInJava7 {

	// Underscores in number literals

	public void underscoreInNumberLiterals() {
		int a = 1_000_100;
		long b = 1_000_000_000_000L;
		double c = 1_000_000_000.0;
		double d = 2___3;

		// int not_valid_a = _100; cannot put at beginning of a number

		// double not_valid_b = 13_.0; // cannot put underscore before a decimal

		// int not_valid_c=100_; // cannot put at end of a number

		// float not_valid_d = 100_F; // not valid before an F
	}

	public void UsingStringInSwitchStatements() {
		String month = "January";
		String march = "march";
		switch (month) {
		case "January":
			System.out.println("1");
			break;
		case "February":
			System.out.println("2");
			break;
		// only constants allowed
		// case march:
		// System.out.println("3");
		default:
			System.out.println("0");
		}

	}

	public void InvokeInstanceOfGenericClassWithDiamond() {
		Map<String, String> mapA = new HashMap<String, String>(); // valid

		Map<String, String> mapB = new HashMap<>(); // valid

		Map<String, String> mapC = new HashMap(); // compiler generates a
													// warning

	}

	public void tryWithResource() throws FileNotFoundException, IOException {
		File fileA = new File("file");
		try (BufferedReader reader = new BufferedReader(new FileReader(fileA))) {
			String s = "";
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		}

	}

	public void catchMultipleExceptions() {
		File fileA = new File("file");
		try (BufferedReader reader = new BufferedReader(new FileReader(fileA))) {
			String s = "";
			while ((s = reader.readLine()) != null) {
				System.out.println(Integer.parseInt(s));
			}
		} catch (IOException | NumberFormatException e) {

		}
	}
}

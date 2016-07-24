package com.studytrails.io;

import java.io.IOException;
import java.io.StringWriter;

public class StringWriterExamples {

	public static void main(String[] args) throws IOException {
		//TODO: Writing characters to a string buffer
		// String Writer class can be used to write characters to a string
		// buffer.
		// the string buffer can then be converted to string. We create an
		// initial buffer size of 10
		StringWriter stringWriter = new StringWriter(10);

		// append single character to the stringwriter buffer.
		stringWriter.append('a');

		// write a string
		stringWriter.append("bcd");

		// writer a char array
		stringWriter.write(new char[] { 'e', 'f', 'g' });

		// writer 1 character from a char array starting from index 1. writes i
		stringWriter.write(new char[] { 'h', 'i', 'j' }, 1, 1);
		
		// get the buffer
		StringBuffer buffer = stringWriter.getBuffer();
		
		System.out.println(buffer);

	}

}

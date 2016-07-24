package com.studytrails.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExamples {
	public static void main(String[] args) throws IOException {
		// THe file writer class is used to write character streams to a file.
		// It uses the default encoding and byte buffer size.. It delegates all
		// its calls to
		// an output stream writer, by passing it a fileoutputstream.
		FileWriter writer = new FileWriter("output.txt");

		// TODO: How to write a character to a file.
		// this methods encodes the character using default encoding and writes
		// it to the file.
		writer.write('a');

		// TODO: How to write a string to a file
		writer.write("def");

		// flush data
		writer.flush();
		
		
	}
}

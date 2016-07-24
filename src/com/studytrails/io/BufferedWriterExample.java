package com.studytrails.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
	public static void main(String[] args) throws IOException {
		// TODO : using a buffered writer to write to a file
		// create a buffered writer with a default buffer of 8192
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

		// TODO : How to write to a file using buffereing
		writer.write('a');
		writer.append('d');
		writer.write("def");
		// TODO: how to insert a new line while writing to a file.
		// This uses the default line separator
		writer.newLine();

		// flush the writer. Note that this method flushes the character from
		// the buffered writer to the underlying
		// writer, however it does not call the flush method of the underlying
		// writer. In this case, the flush method
		// will write the characters to a file writer which uses a output stream
		// writer which uses the standard encorder
		// of the provider.
		writer.flush();
	}
}

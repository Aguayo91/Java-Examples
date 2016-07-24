package com.studytrails.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExamples {

	public static void main(String[] args) throws IOException {
		// the printwriter class writes to a textual output stream. Its
		// constructor creates a bufferedwriter
		// new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(file))),false)
		// the outputstreamwriter encodes the characters and as the code
		// comments puts it
		// 'is a bridge from character streams to byte streams'. File output
		// stream writes bytes to the file.
		// TODO : Writing to a file
		PrintWriter writer = new PrintWriter(new File("output.txt"));

		// TODO How to write to a file in java with authomatic flushing
		// It is also possible to create a filewriter with automatic flushing.
		// however autoflushing only happens when
		// one of the println,printf or format methods are called.
		PrintWriter writer2 = new PrintWriter(new BufferedWriter(
				new FileWriter(new File("output2.txt"))), true);

		// TODO: how to write characters to file using printwriter
		// both methods do the same thing
		writer.append('a');
		writer.write('b');
		writer.print('k');

		// TODO: How to write part of string to a file using printwriter
		writer.append("def", 1, 1);
		writer.write("keep", 2, 2);

		// writer.format(format, args)
		// writes boolean values
		// TODO: how to write java objects and to a file
		writer.print(true);
		// double
		writer.print(1.434);
		// float
		writer.print(1.23f);
		writer.print(2);
		// writes any object to a file by calling its toString method.
		writer.print(writer);

		// terminates the current line. Uses the system specific line separator.
		writer.println();

		// use println methods with any object to write the string
		// representation of the object followed by a new line.
		writer.println(3);
		// TODO: how to writer formatted string to file.
		// the java formatter can be used to format a string. This method writes
		// formatted string to a file based on the default formatter
		writer.printf("%a", 34.0);
		// the flush method needs to be called explicitly unless one of the
		// methods that flush automatically are called.
		writer.flush();

		// TODO : How to check for errors since PrintWriter does not throw
		// IOException
		// before closing the stream check whether any error has been thrown.
		// The methods of this class
		// do not throw IOException
		writer.checkError();
		writer.close();

	}
}

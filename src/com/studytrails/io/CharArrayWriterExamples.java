package com.studytrails.io;

import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayWriterExamples {
	public static void main(String[] args) throws IOException {
		// the char array writer can be used to write to a character array that
		// automatically grows in size
		// TODO : How to writer characters to a character array that grows
		// automatically
		CharArrayWriter writer = new CharArrayWriter();
		// append a character to a char array
		writer.append("c");

		// append a sequence of characters, does not throw IO exception
		writer.append("def");
		// append a sequence of character, throws IO Exception, since method
		// comes from the writer interface
		writer.write("khi");

		// get the current size of the buffer
		writer.size();

		// get the character array converted to a string
		System.out.println(writer.toString());
		// start all over again, but use the same allocated buffer
		writer.reset();

	}
}

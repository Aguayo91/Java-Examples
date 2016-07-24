package com.studytrails.apache.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class IOUtilsExamples {

	public static void main(String[] args) throws IOException {
		// create a file in temporary directory for this example
		File file = FileUtils.getFile(FileUtils.getTempDirectory(),
				"IoUtils.txt");
		FileUtils.touch(file);

		File file2 = FileUtils.getFile(FileUtils.getTempDirectory(),
				"IoUtils2.txt");
//		FileUtils.touch(file2);
		// TODO : close a connection in a final block without worrying about
		// exceptions
//		FileInputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(file);
//			// read the file here
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			IOUtils.closeQuietly(inputStream);
//		}

		// In all of the methods below bufferring is taken care of by the
		// IOUtils class
		// and external buffering is not required.
		// TODO: get the contents of an input stream as byte array
//		inputStream = new FileInputStream(file);
//		byte[] data = IOUtils.toByteArray(inputStream);

//		 TODO : Get the contents of a URL as byte array
//		byte[] data2 = IOUtils.toByteArray(new URL("http://www.google.com"));

		// TODO : get teh contents of input stream as String
//		String s = IOUtils.toString(inputStream);

		// TODO: get the contents of inputstream as list of Strings
//		List<String> lines = IOUtils.readLines(inputStream);

		// TODO: convert a string to input stream
//		InputStream stream2 = IOUtils
//				.toInputStream("String to be converted to input stream");

		// TODO: write array of bytes to output stream.
//		OutputStream outputStream = new FileOutputStream(file);
//		IOUtils.write(data2, outputStream);

		// TODO: write a collection of lines to outputstream
//		IOUtils.writeLines(lines, null, outputStream);

		// TODO: copy contents from one file to another
//		IOUtils.copy(new FileInputStream(file), new FileOutputStream(file2));
	}

}

package com.studytrails.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class ReaderExample {
	public static void main(String[] args) {
		// TODO how to read from a text file and write to another file
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader("in.txt");
			writer = new FileWriter("out.txt");
			int a = 0;
			while ((a = reader.read()) != -1) {
				writer.write(a);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// Read a text file using buffered reader
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("in.txt"));
			bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));
			String s = "";
			while ((s = bufferedReader.readLine()) != null) {
				bufferedWriter.write(s);
				// write a new line
				bufferedWriter.newLine();
				// flush
				bufferedWriter.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close without throwing exception
			IOUtils.closeQuietly(bufferedReader);
			IOUtils.closeQuietly(bufferedWriter);
		}
		// TODO How to read text from a unicode
		// Lets see what we get if we use a FileReader without specifying a
		// charset
		// FileReader reader2 = new FileReader("inUnicode.txt");
		// int b = 0;
		// while ((b = reader2.read()) != -1) {
		// // cast to char. The casting removes the left most bit. Since we are
		// // using a reader, the byte has already
		// // been encoded properly
		// char c = (char) b;
		// System.out.print(c);
		// }
		System.out.println();
		// next we specify the charset to be unicode
		// Reader readerUnicode = new InputStreamReader(new FileInputStream(
		// "inUnicode.txt"), Charset.forName("UTF-16"));
		// int e = 0;
		// while ((e = readerUnicode.read()) != -1) {
		// // cast to char. The casting removes the left most bit. Since we are
		// // using a reader, the byte has already
		// // been encoded properly
		// char f = (char) e;
		// System.out.print(f);
		// }
		// TODO: How to read data from a url and write to a file
		// open a url connection
		// create an output print writer with auto flush set to true
		// PrintWriter writer = new PrintWriter(new FileWriter("out.txt"),
		// true);
		// URL url = new URL("http://www.google.com");
		// HttpURLConnection connection = new HttpURLConnection(url, null);
		// connection.connect();
		// BufferedReader urlReader = new BufferedReader(new InputStreamReader(
		// connection.getInputStream()));
		// String s = "";
		// while ((s = urlReader.readLine()) != null) {
		// writer.println(s);
		// }
		// writer.close();
		// connection.disconnect();

	}
}

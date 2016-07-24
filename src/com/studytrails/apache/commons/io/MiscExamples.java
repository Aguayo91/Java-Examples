package com.studytrails.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.apache.commons.io.input.TailerListenerAdapter;

public class MiscExamples {
	public static void main(String[] args) throws IOException {
		// the charsets class gives standard nio charsets
		// TODO how to get ascii charset for java
		Charset asciiCharset = Charsets.US_ASCII;
		// TODO how to get utf 8 charset for java
		Charset utfCharset = Charsets.UTF_8;
		// TODO : How to Find out free Space in a directory
//		System.out.println(FileSystemUtils.freeSpaceKb("C:/"));
		// TODO: construct a file name from name elements
//		File file = FileUtils.getFile("C:", "work", "java", "sample.txt");
//		System.out.println(file.getAbsolutePath());
		// TODO: Get the path of temporary directory
		System.out.println(FileUtils.getTempDirectoryPath());
		// TODO: How to get a human readable file size
		// this returns the empty space in temporary directory in human readable
		// form
//		System.out.println(FileUtils.byteCountToDisplaySize(FileSystemUtils
//				.freeSpaceKb(FileUtils.getTempDirectoryPath())));
		// TODO: implement unix 'touch' like command
		FileUtils.touch(FileUtils.getFile(FileUtils.getTempDirectoryPath(),
				"temp.txt"));
		// TODO: list all .txt file in a directory (including sub directories)
		// using a file and directory fiter.
//		Collection<File> files = FileUtils.listFiles(
//				FileUtils.getFile("C:", "work", "eclipse"),
//				FileFilterUtils.suffixFileFilter(".txt"),
//				TrueFileFilter.INSTANCE);
//		for (File filea : files) {
//			System.out.println(filea.getAbsolutePath());
//		}
		// TODO: Find files in a directory that match an array of extension
//		Collection<File> filesb = FileUtils.listFiles(
//				FileUtils.getFile("C:", "work", "eclipse"), new String[] {
//						"txt", "jar" }, true);
//		for (File filea : filesb) {
//			System.out.println(filea.getAbsolutePath());
//		}
		/*// TODO: copy files preserving the time stamp
		File tempFile = FileUtils.getFile(FileUtils.getTempDirectory(),
				"eclipse.ini");
		FileUtils.copyFile(
				FileUtils.getFile("C:", "work", "eclipse", "eclipse.ini"),
				tempFile);
		System.out.println(Files.getLastModifiedTime(tempFile.toPath()));
*/
		// TODO: copy directory to another directory
//		FileUtils.copyDirectory(
//				FileUtils.getFile("C:", "work", "eclipse", "readme"),
//				FileUtils.getFile(FileUtils.getTempDirectory(), "readme"));

		// TODO: read data from a URL and copy to a file
//		FileUtils.copyURLToFile(new URL("http://www.google.com"), FileUtils
//				.getFile(FileUtils.getTempDirectory(), "googleHomePage.txt"));

		// TODO: Delete a directory recursively
//		FileUtils.deleteDirectory(FileUtils.getFile(
//				FileUtils.getTempDirectory(), "readme"));

		// TODO: read the contents of a file into a string. There is a similar
		// write method too.
//		String googleHomePage = FileUtils.readFileToString(FileUtils.getFile(
//				FileUtils.getTempDirectory(), "googleHomePage.txt"));

		// TODO: read file into a list of strings
//		List<String> googleHomePageLines = FileUtils.readLines(FileUtils
//				.getFile(FileUtils.getTempDirectory(), "googleHomePage.txt"));

		/*// TODO: get the size of a file or a directory
		System.out.println(FileUtils.byteCountToDisplaySize(FileUtils
				.sizeOf(FileUtils.getTempDirectory())));
*/
//		FileUtils.deleteQuietly(FileUtils.getFile("C:", "work",
//				"googleHomePage.txt"));
		// TODO: How to move a file. Similar methods exist to move directory.
		// There are various variants of these method
//		FileUtils.moveFile(FileUtils.getFile(FileUtils.getTempDirectory(),
//				"googleHomePage.txt"), FileUtils.getFile("C:", "work",
//				"googleHomePage.txt"));
		// TODO: How to implement a 'tail' in java.
//		class MyTailerListener extends TailerListenerAdapter {
//			public void handle(String line) {
//				System.out.println(line);
//			}
//		}
//		TailerListener listener = new MyTailerListener();
//		Tailer tailer = Tailer.create(file, listener, 10000);
//		tailer.stop();

		// TODO read lines in a file reversely
//		ReversedLinesFileReader reader = new ReversedLinesFileReader(FileUtils.getFile("C:", "work", "eclipse", "readme","readme_eclipse.html"));
//		String s = "";
//		while ((s = reader.readLine()) != null) {
//			System.out.println(s);
//		}
	}
}

package com.studytrails.io;

import java.io.File;
import java.io.IOException;

public class FileExamples {

	public static void main(String[] args) throws IOException {

		File file = new File("c:\\work\\eclipse\\eclipse.ini");
		
		System.out.println(file.exists());

		// file methods
		// get the absolute file path
//		System.out.println(file.getAbsoluteFile());

		// TODO is file executable?
//		System.out.println(file.canExecute());

		// TODO is file readable?
//		System.out.println(file.canRead());

		// TODO is file writable?
//		System.out.println(file.canWrite());

		// TODO create a new file.
		File file2 = new File("eclipse2.ini");
//		System.out.println(file2.createNewFile());
//        Path path = file2.toPath();
//        Files.createFile(path, new FileAttribute<?>[0]);
		// TODO deleting a file
//		System.out.println(file2.delete());

		// TODO difference between absolute path and cannonical path. The
		// examples
		// below explain what the different 'paths' mean.
		File file3 = new File("./../eclipse.ini");
//		file3.createNewFile();
//		System.out.println(file3.getAbsolutePath());// prints C:\work\java\WS\java-io\.\..\eclipse.ini
//		System.out.println(file3.getCanonicalPath());// prints C:\work\java\WS\eclipse.ini
//		System.out.println(file3.getParent()); // prints  .\..
//		System.out.println(file3.getAbsoluteFile().getParent());// prints C:\work\java\WS\java-io\.\..
//		System.out.println(file3.getName()); // prints eclipse.ini
//		System.out.println(file3.getPath());// prints .\..\eclipse.ini
//		System.out.println(file3.isAbsolute());// prints false

		// TODO check whether the File object represents a file (and not a
		// directory)
//		System.out.println(file3.isFile());

		// TODO check whether the file object is a directory. does the
		// getParentFile() always return a directory?
//		System.out.println(file3.getParentFile().isDirectory());
//		System.out.println(file3.isFile());
		// TODO get the last modified time stamp (milliseconds since epoch)
//		System.out.println(file3.lastModified());
//		System.out.println(file3.toURI());

		// TODO get the total space of the partition in which where this file
		// belongs
//		System.out.println(file3.getTotalSpace());

		// TODO get the free space available in the partition
//		System.out.println(file3.getFreeSpace());

		// TODO get the list of files in the directory. this returns both files
		// and
		// directories represented by the abstract file name
		File dir = file3.getParentFile();
//		String[] everythingInThisDir = dir.list();
//		for (String name : everythingInThisDir) {
//			System.out.println(name);
//		}

		// TODO list selected files in a directory. uses a file filter
		// implemented as
		// an anonymous inner class.
//		File[] selectedFiles = dir.listFiles(new FileFilter() {
//			@Override
//			public boolean accept(File pathname) {
//
//				if ("java-io".equals(pathname.getName()))
//					return true;
//				return false;
//			}
//		});
//		for (File selectedFile : selectedFiles) {
//			System.out.println(selectedFile.getAbsolutePath());
//		}

		// TODO rename a file. This is a platform dependent method
//		file3.renameTo(new File("eclipse4.ini"));

		// TODO directory creation
		// creates directory named a
//		System.out.println(new File("./a").mkdir());

		// directory creation fails because 'b' does not exist
//		System.out.println(new File("./b/a").mkdir());

		// this creates all missing directories. i.e creates both b and a
//		System.out.println(new File("./b/a").mkdirs());

		// clean up for the tutorial
//		file3.delete();
//		(new File("./b/a")).delete();
//		(new File("./b")).delete();
//		(new File("./a")).delete();

	}

}

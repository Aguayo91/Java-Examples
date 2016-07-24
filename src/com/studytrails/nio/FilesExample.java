package com.studytrails.nio;

import static java.security.AccessController.doPrivileged;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;
import java.util.Iterator;

import sun.security.action.GetPropertyAction;

public class FilesExample {
	public static void main(String[] args) throws IOException {
   
		// create a file to play around. we use the eclipse.ini file. just put
		// the file in a place that is accessible by this class file
		File file = new File("eclipse.ini");
		// get the java.nio.file.path from this
		Path filePath = file.toPath();

		// first, we get the temporary directory path.
		Path tempDir = Files.createTempDirectory("java.nio.example",
				new FileAttribute<?>[0]);
		// lets create a temporary file which we will use later. The File
		// Attribute can be used to pass the permissions for the file or to
		// specify that the file be closed on exit.
		EnumSet<StandardOpenOption> options = EnumSet.<StandardOpenOption> of(
				StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
		Path tempFilePath = Files.createTempFile(tempDir, "temp", "a",
				new FileAttribute<?>[0]);
		// the temporary file is created in the temporary directory which is, in
		// turn, created in the default temp directory
		// here's how to see where the temp directory is
		System.out.println(Paths.get(doPrivileged(new GetPropertyAction(
				"java.io.tmpdir"))));
		// let us create an outputstream from the temporary path and let it be
		// deleted on close
		OutputStream out = Files.newOutputStream(tempFilePath,
				StandardOpenOption.DELETE_ON_CLOSE);
		// use the copy method to copy contents to the outputstream. The copy
		// works by copying contents from source,
		// putting it in a buffer and then writing the buffer to the
		// outputstream. There are various variants of this
		// method. we could use path for both source and target or a path for
		// target and an inputstream for source.
		// This later method can be used to read files from the web
		// TODO : How to read a file from the web and write contents to a local
		// file.
//		Files.copy(filePath, out);

		// TODO : How to create a directory?
		Path cPath = Files.createDirectory(FileSystems.getDefault()
				.getPath("c"), new FileAttribute<?>[0]);
		// creating a directory 'b' and another directory 'a' inside it. the
		// getPath method concatenates the path using the default
		// name-separator.
		// TODO: How to create a directory and its parent(s)?
		Path ainb = Files.createDirectories(
				FileSystems.getDefault().getPath("./b", "a"),
				new FileAttribute<?>[0]);

		// TODO how to create a hard link. This example does not work on all
		// operating systems
		 Files.createLink(FileSystems.getDefault().getPath("a-link"), ainb);
		// TODO How to delete a file or directory
		Files.delete(cPath);
		// TODO How to delete a file or directory only if it exists
//		Files.deleteIfExists(cPath);
		// TODO How to check if a file or directory exists. A symbolic link is
		// followed by default. The deafult behaviou
		// may be changed by using the NOFOLLOW_LINKS option
		System.out.println(Files.exists(cPath, LinkOption.NOFOLLOW_LINKS));

		// get the basic attributes of a file
		BasicFileAttributes basicAttributes = Files.readAttributes(
				tempFilePath, BasicFileAttributes.class);
		// TODO : how to get the last access time for a file or a directory
//		System.out.println(basicAttributes.lastAccessTime());
		// TODO : How to get the last modified time for a file or a directory
//		System.out.println(basicAttributes.lastModifiedTime());
		// TODO : get the creation time of a file or a directory
//		System.out.println(basicAttributes.creationTime());
		// TODO : How to get the size of a file
//		System.out.println(basicAttributes.size());
		// TODO : How to check whether the file represents a directory
//		System.out.println(basicAttributes.isDirectory());
		// TODO : How to check whether the file represents a regular file
//		System.out.println(basicAttributes.isRegularFile());
        
		// The file store gives the storage system for the file
//		FileStore store = Files.getFileStore(tempFilePath);
		// TODO : What is the name of the storage system of the file
//		System.out.println(store.name());
		// TODO : How to get the total storage space of the partition in which
		// the file resides
//		System.out.println(store.getTotalSpace());
		// TODO : How to get the total usable space of the parition in which the
		// file resides
//		System.out.println(store.getUsableSpace());
		// TODO : How to get the file system in which the file resides` `
//		System.out.println(store.type());
		// TODO : How to find out the owner of a file
//		System.out.println(Files.getOwner(tempFilePath,
//				LinkOption.NOFOLLOW_LINKS));
		// TODO : How to find the posix file permissions of a file
		// Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(
		// tempFilePath, LinkOption.NOFOLLOW_LINKS);
		// System.out.println(Arrays.toString(permissions.toArray()));
		// a file or a directory can be moved using the move method. A directory
		// needs to be empty if moved to a separate file system
		// TODO : How to move file or directory
//		tempFilePath = Files.move(tempFilePath, FileSystems.getDefault()
//				.getPath("meaningfulname.txt"),
//				StandardCopyOption.REPLACE_EXISTING);
		// move contents of directory b to directory c
		// TODO : How to move contents of a directory
//		Files.move(FileSystems.getDefault().getPath("b"), cPath,
//				StandardCopyOption.ATOMIC_MOVE);

		// TODO: How to get a buffered reader using a particular charset
//		BufferedReader reader = Files.newBufferedReader(tempFilePath,
//				StandardCharsets.UTF_8);
		// TODO: how to get a buffered writer in append mode
//		Files.newBufferedWriter(tempFilePath, StandardCharsets.UTF_8,
//				StandardOpenOption.APPEND);
		// A method is presented to iterate over the paths in a directory. The
		// directory stream object can be iterated

		// TODO : How to get an input stream in append mode
//		Files.newInputStream(tempFilePath, StandardOpenOption.READ);

		// TODO : How to get the content type of a file
//		System.out.println(Files.probeContentType(tempFilePath));

		// great utility methods to read small and medium sized files.
		// Read all bytes in a file in a byte array
//		System.out.println(Files.readAllBytes(tempFilePath));
		// Read all lines in a file and return a list of lines
//		Files.readAllLines(tempFilePath, StandardCharsets.UTF_8);

		Path tmpFilePath2 = Files.createTempFile(tempDir, "temp", "a",
				new FileAttribute<?>[0]);

		// Utility method to write bytes to a file
//		Files.write(tempFilePath, Files.readAllBytes(tmpFilePath2),
//				StandardOpenOption.APPEND);

		// traverse or walk the file tree. Uses the visitor pattern.
		// four methods
//		Files.walkFileTree(FileSystems.getDefault().getPath("C:\\entertainment\\music\\hindi-old"), new FileVisitor<Path>() {
//			@Override
//			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
//					throws IOException {
//				System.out
//						.println("FilesExample.main(...).new FileVisitor() {...}.postVisitDirectory()");
//				System.out.println(dir.getFileName());
//				return FileVisitResult.CONTINUE;
//			}
//
//			@Override
//			public FileVisitResult preVisitDirectory(Path dir,
//					BasicFileAttributes attrs) throws IOException {
//				System.out
//						.println("FilesExample.main(...).new FileVisitor() {...}.preVisitDirectory()");
//				System.out.println(dir.getFileName());
//				return FileVisitResult.CONTINUE;
//			}
//
//			@Override
//			public FileVisitResult visitFile(Path file,
//					BasicFileAttributes attrs) throws IOException {
//				System.out
//						.println("FilesExample.main(...).new FileVisitor() {...}.visitFile()");
//				System.out.println(file.getFileName());
//				return FileVisitResult.CONTINUE;
//			}
//
//			@Override
//			public FileVisitResult visitFileFailed(Path file, IOException exc)
//					throws IOException {
//				System.out
//						.println("FilesExample.main(...).new FileVisitor() {...}.visitFileFailed()");
//				System.out.println(file.getFileName());
//				return FileVisitResult.CONTINUE;
//			}
//		});

//		Files.delete(tempFilePath);
//		Files.delete(FileSystems.getDefault().getPath("c", "a"));
//		Files.delete(cPath);
//		DirectoryStream<Path> stream = Files.newDirectoryStream(tempDir);
//		Iterator<Path> iter = stream.iterator();
//		while (iter.hasNext()) {
//			Path path = iter.next();
//			System.out.println(path.getNameCount());
//		}
		
       //TODO: How to copy files effectively 
	}
}

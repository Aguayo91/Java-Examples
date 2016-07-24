package com.studytrails.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReadingHugeFilesUsingMemoryMappedBuffer {
	/**
	 * use a MappedByteBuffer to wrap a huge file. Using a MappedByteBuffer does
	 * not load the file in JVM but reads it directly off the file system
	 * memory. The file can be opened in read, write or private mode.
	 */
	// to test you can use any video movie file if you dont have any other large
	// file for testing.
	private static String hugeFile = "C:\\Users\\mithil\\Videos\\VIDEO_TS\\VTS_04_1.VOB";

	public static void main(String[] args) throws IOException {
		File file = new File(hugeFile);
		FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();
		MappedByteBuffer buffer = fileChannel.map(
				FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
		// the buffer now reads the file as if it were loaded in memory. note
		// that for smaller files it would be faster
		// to just load the file in memory
		// lets see if this buffer is loaded fully into memory
		System.out.println(buffer.isLoaded());
		// the mappedbytebuffer can be used as a normal buffer to do read and/or
		// write operations
		// read the size
		System.out.println(buffer.capacity());
	

	}
}

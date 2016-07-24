package com.studytrails.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

import org.apache.commons.io.FileUtils;

public class FileChannelExample {
	/**
	 * * A FileChannel is used to read and write data to a file. It implements
	 * seekableByteChannel, ScatteringByteChannel and GatheringByteChannel. It
	 * is possible to map a region of file directly into memory. Data can be
	 * transferred to another channel or from another channel using the
	 * transferTo(..) and transferFrom(..) methods. These methods use the
	 * underlying optimization of the operating system. File locking can be
	 * applied to manage access between multiple processes. The methods are
	 * thread safe and a thread that wishes to modify the position may be
	 * blocked until another thread is acting upon the file.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// create a temp file
		System.out.println(FileUtils.getTempDirectoryPath());
		Path tempFile = Files.createTempFile("fileChannelExample", "txt",
				new FileAttribute<?>[0]);
		// write some data to this file
		PrintWriter writer = new PrintWriter(tempFile.toFile());
		writer.println("First Line");
		writer.println("Second Line");
		writer.println("Third Line");
		writer.flush();
		writer.close();
		// get an input stream for this file.
		FileInputStream in = new FileInputStream(tempFile.toFile());

		// get the fileChannel for this input stream
		FileChannel fileChannel = in.getChannel();
		// get the position
		System.out.println(fileChannel.position());
		// create a char buffer
		ByteBuffer buffer = ByteBuffer.allocate(11);
		// read the fist line - 10 characters into the byte buffer
		fileChannel.read(buffer);
		// get the position of the file
		System.out.println(fileChannel.position());
		// we have read the first 10 chars into the buffer now. find out the
		// total size of the file
		System.out.println(fileChannel.size());
		// TODO : How to read from a channel into multiple buffers
		// we read the next 27 characters in two buffers using a scattering read
		ByteBuffer buffer1 = ByteBuffer.allocate(14);
		ByteBuffer buffer2 = ByteBuffer.allocate(12);
		fileChannel.read(new ByteBuffer[] { buffer1, buffer2 });
		// lets see the contents of the buffers
		buffer1.flip();
		buffer2.flip();
		System.out.println(Charset.defaultCharset().decode(buffer1));
		System.out.println(Charset.defaultCharset().decode(buffer2));
		fileChannel.close();

		// TODO : How to write bytes at a channel using a scattering write.
		// we can write the bytes back to the file using a scattering write
		// the filechannel was created on the inputstream so the channel is only
		// readable but not
		// writable. we create a filechannel from an output stream
		FileOutputStream out = new FileOutputStream(tempFile.toFile());
		FileChannel fileOutputChannel = out.getChannel();
		ByteBuffer buffer3 = Charset.defaultCharset().encode(
				CharBuffer.wrap("Line1\n".toCharArray()));
		ByteBuffer buffer4 = Charset.defaultCharset().encode(
				CharBuffer.wrap("Line2".toCharArray()));
		fileOutputChannel.write(new ByteBuffer[] { buffer3, buffer4 });
		// we force the update to the file
		fileOutputChannel.force(true);
		// lets look at the position in the file
		System.out.println(fileOutputChannel.position());
		// this finishes the example that demonstrates reading and writing to
		// filechannel from a char buffer. The example
		// also demonstrates a scatter read and a scatter write. In the next
		// example, we look at selectors and socket channel
		// TODO: How to copy contents from one file to another.
//		Path tempFile2 = Files.createTempFile("fileChannelExample2", "txt",
//				new FileAttribute<?>[0]);
//		// get an inputstream from file1
//		FileInputStream streamTemp1 = new FileInputStream(tempFile.toFile());
//		// get the file channel
//		FileChannel channel1 = streamTemp1.getChannel();
//		// get the file to which the contents are to be copied
//		FileOutputStream outputStream = new FileOutputStream(tempFile2.toFile());
//		// get the channel for the second file
//		FileChannel channel2 = outputStream.getChannel();
//		// transfer data from channel 1 to channel 2
//		channel1.transferTo(0, tempFile.toFile().length(), channel2);

	}
}

package com.studytrails.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
	// random access file behaves like an array of bytes. It can be used to both
	// read and write bytes.
	// RandomAccessFile allows to read or write data at a particular position.
	// The RandomAccessFile implements the DataInput and DataOutput interfaces
	// and hence allows
	// reading and writing java primitive types
	public static void main(String[] args) throws IOException {
		// TODO : How to read and write into a random access file.
		// the file can be opened in both read only mode and read write mode.
		// This examples opens the file
		// in read write mode.
		RandomAccessFile randomAccessFile = new RandomAccessFile(new File(
				"randomAccessFile.txt"), "rw");
		// write an int
		randomAccessFile.writeInt(1);
		String stringA = "Writing a long string in the RandomAccessFile";
		randomAccessFile.writeChars(stringA);

		// after writing the data into the RandomAccessFile, we will attempt to
		// read it.
		// first let us see what the current position of the file is
		System.out.println(randomAccessFile.getFilePointer());
		// this gives the number of bytes that have been written so far and the
		// position of the pointer.
		// The current position should be equal to the length of the file.
		System.out.println(randomAccessFile.length());
		// set the pointer at the beginning of the file so that we can start
		// reading it.
		randomAccessFile.seek(0);

		// we then star reading it
		System.out.println(randomAccessFile.readInt());
		// lets see where the pointer is
		System.out.println(randomAccessFile.getFilePointer());
		// the int is stored in 4 bytes, so the pointer is at 4.
		// we could read the next two byte or read till the end of the file and
		// store
		// all byes read into a string. If the file was large, we would have
		// used a buffer
		byte[] allOtherByteData = new byte[(int) randomAccessFile.length() - 4];
		randomAccessFile.read(allOtherByteData);
		// there are ways to convert the byte array to a char array, but lets do
		// it the hard way
		// char is stored as two bytes in java, so we expect the length of the
		// byte array to be a multiple of 2
		// (note that for this example, we know for sure that except for the
		// first four bytes, all other bytes
		// are part of the string 'stringA', that is the reason we will attempt
		// to convert all the remaining
		// bytes to char.)
		// TODO: How to convert a byte array to a char array
		int j = 0;
		char[] allOtherCharData = new char[allOtherByteData.length / 2];
		for (int i = 0; i < allOtherByteData.length; i++) {
			byte firstByte = allOtherByteData[i++];
			byte secondByte = allOtherByteData[i];
			// the two bytes read need to be combined to form a char.
			char a = (char) ((firstByte >> 8) | (secondByte & 0xff));
			// add the char to the char array
			allOtherCharData[j++] = a;
		}
		// the char array should contain the string 'stringA'
		System.out.println(allOtherCharData);

	}
}

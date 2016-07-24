package com.studytrails.nio;

import java.nio.ByteBuffer;

public class BufferExamples {
	private static ByteBuffer byteBuffer;

	/**
	 * Buffers are containers of data. They store bytes and other primitive java
	 * types in arrays and allow processes to read and write bytes onto them.
	 * Buffers have three important properties. 1. Position - identifies the
	 * index where the next byte will be written or read. 2. Limit - identifies
	 * the index where there is no byte for reading or where byte should not be
	 * written. 3. Capacity - identifies the count of bytes that can be
	 * accomodated in the buffer.
	 * 
	 * 
	 */
	public static void main(String[] args) {

		// a byte buffer is a buffer of bytes
		// TODO : How to create a byte buffer.
		// one way to create byte buffer is by allocating memory in the heap
		// space. The call below allocates 10 bytes to the buffer.

		System.out.println(Runtime.getRuntime().freeMemory());
		ByteBuffer byteBuffer1 = ByteBuffer.allocate(100000000);
		// We check the free memory in jvm after allocating
		// memory for the bytebuffer.
		System.out.println(Runtime.getRuntime().freeMemory());
		// a byte buffer may also be created by allocating memory outside the
		// jvm and directly in the os memory
		ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(100000000);
		// in the case of direct allocation the free memory available in the jvm
		// does not change.
		System.out.println(Runtime.getRuntime().freeMemory());
		// a last way to create byte buffer is to create a wrapper around an
		// existing byte array. It points to the data of the wrapped array and
		// hence creates just a view
		ByteBuffer byteBuffer3 = ByteBuffer.wrap(byteBuffer1.array());
		System.out.println(Runtime.getRuntime().freeMemory());

		// a shorter buffer is created to explain the mechanics of read and
		// write.
		// notice how position, limit and capacity changes as we operate on the
		// buffer
		byteBuffer = ByteBuffer.allocate(10);
		// a glimpse into the position, limit and capacity of the byte buffer
		printPos();

		// we write 1 char or two bytes to the buffer. The put method can be
		// used to 'put' or write values in the buffer
		// the values are put at the current position. various variants of the
		// put methods are available and they can write
		// the various primitive types.
		byteBuffer.putChar('a');
		// lets see how our buffer looks like now
		printPos();
		// as we expected the char writes two bytes into the buffer and hence
		// increments the position by 2. (0,1).
		// this implies that the next byte will be written at index 2 (remember
		// index starts from 0)
		// lets write an int
		byteBuffer.putInt(1);
		printPos();
		// int occupies 4 bytes.
		// the position is at 6. lets go back to 0 and start reading
		byteBuffer.flip();
		printPos();
		// we are now trying to read the bytes that we have written. flip takes
		// us to the start of the buffer
		// and also sets the limit to 6 so that we know that we can read upto
		// the 6 th element (0 to 5)
		// we read the first two bytes
		System.out.println(byteBuffer.getChar());
		printPos();
		// we planned to read all bytes that we had written but we want to write
		// another int now.
		// since we have already read the char, lets compact the buffer by
		// shifting the bytes that we have already read out
		byteBuffer.compact();
		printPos();
		// so now the first four bytes are occupied by the int that we had
		// originally written and the next six bytes
		// are available for writing
		// we write another int
		byteBuffer.putInt(2);
		printPos();
		// lets start reading 
		byteBuffer.flip();
		System.out.println(byteBuffer.getInt());
		System.out.println(byteBuffer.getInt());
		printPos();
		// what if we want to read the same buffer again?
		byteBuffer.rewind();
		System.out.println(byteBuffer.getInt());
		printPos();
		// lets mark this position
		byteBuffer.mark();
		// read the next int
		System.out.println(byteBuffer.getInt());
		printPos();
		// go back to the marked position
		byteBuffer.reset();
		printPos();

		// that's it. to start again. clear everything
		byteBuffer.clear();
		printPos();

	}

	private static void printPos() {
		System.out.println("position:" + byteBuffer.position() + ";limit:"
				+ byteBuffer.limit() + ";capacity:" + byteBuffer.capacity());
	}
}

package com.studytrails.nio;

public class ChannelExamples {
	/**
	 * A channel represents a connection to a file, socket or any other component that can perform IO operations. A channel
	 * reads or writes data to a byte buffer. Channels are generally thread safe. A channel may be specified to be read only
	 * or both readable and writable. 
	 * A ReadableByteChannel permits read operation on a buffer, allowing only one thread to read at a time.
	 * A WritableByteChannel permits write operation on a buffer, allowing only one thread to read at a time.
	 * A ByteChannel extends both ReadableByteChannel and WritableByteChannel and allows both read and write. 
	 * A SeekableByteChannel extends ByteChannel and allows to maintain and modify the current position on the underlying
	 * entity to which it is connected. It has methods to get the size of the underlying entity or truncate it to a given size, 
	 * if permitted.
	 * A GatheringByteChannel is used to write data from multiple buffers into a single channel.
	 * A ScatteringByteChannel is used to read data from a channel into multiple buffers.
	 
	 */
	public static void main(String[] args) {

	}
}

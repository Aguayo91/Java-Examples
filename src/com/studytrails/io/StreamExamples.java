package com.studytrails.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamExamples {
	public static void main(String[] args) throws IOException {
		// TODO : How to write bytes to a file.
		// the buffered stream buffers bytes before writing to an output stream.
		// the default buffer size is 8192.
		// the bytes are written to a buffer. THe buffer is written to the
		// underlyting output stream when the buffer
		// is full or when flush method is called explicitely.
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream("output.txt"));
		// writes a byte to a byte stream. The byte is written as the lower
		// order of an int
		stream.write('b');
		// How to copy a file byte by byte
		stream.write(new byte[] { 'a', 'c' });
		// flushes the stream
		stream.flush();

		// TODO: how to read all bytes from a file and write to another file.
		// The
		// file is checked for read permission before opening
		// FileOutputStream out = new FileOutputStream("out.txt");
		// InputStream input = new FileInputStream("eclipse.ini");
		// int a = 0;
		// while (a != -1) {
		// a = input.read();
		// out.write(a);
		// }
		// input.close();
		// out.close();

		// TODO: how to read data from a file and write to another file using
		// buffer.
		BufferedOutputStream bufferedOut = new BufferedOutputStream(
				new FileOutputStream("out.txt"));
		// the contents of in.txt file are.
		// onetwiceskipend
		// read teh first three char bytes once, read the next five twice, skip
		// the next four
		BufferedInputStream bufferedInput = new BufferedInputStream(
				new FileInputStream("in.txt"));
//		int b = 0;
//		// read the first sentence till line separator is reached
//		byte[] firstThree = new byte[3];
//		bufferedInput.read(firstThree);
//		System.out.println(Charset.defaultCharset().decode(
//				ByteBuffer.wrap(firstThree)));
//
//		// mark the current position, since we would read this again. The mark
//		// position is valid for 5 byes
//		bufferedInput.mark(6);
//
//		// read the next five bytes
//		byte[] nextFive = new byte[5];
//		bufferedInput.read(nextFive);
//		System.out.println(Charset.defaultCharset().decode(
//				ByteBuffer.wrap(nextFive)));
//
//		// go back to the marked position and read it again
//		bufferedInput.reset();
//		byte[] readTheFiveAgain = new byte[5];
//		bufferedInput.read(readTheFiveAgain);
//		System.out.println(Charset.defaultCharset().decode(
//				ByteBuffer.wrap(readTheFiveAgain)));
//
//		// skip the next four
//		bufferedInput.skip(4);
//
//		// read the last three
//		byte[] lastThree = new byte[3];
//		bufferedInput.read(lastThree);
//		System.out.println(Charset.defaultCharset().decode(
//				ByteBuffer.wrap(lastThree)));
//
//		// write to the output stream
//		bufferedOut.write(firstThree);
//		bufferedOut.write(nextFive);
//		bufferedOut.write(readTheFiveAgain);
//		bufferedOut.write(lastThree);
//
//		bufferedOut.flush();
//		bufferedInput.close();
//		bufferedOut.close();

		// TODO How to read continuously from standard input
//		PipedReader pipedReader = new PipedReader();
//		PipedWriter pipedWriter = new PipedWriter(pipedReader);
//
//		StreamExamples examples = new StreamExamples();
//
//		screenReader reader = examples.new screenReader(pipedWriter);
//		OutputWriter writer = examples.new OutputWriter(pipedReader);
//		reader.start();
//		writer.start();

	}

//	class screenReader extends Thread {
//		PipedWriter writer;
//
//		public screenReader(PipedWriter writer) {
//			this.writer = writer;
//		}
//
//		@Override
//		public void run() {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(
//					System.in));
//			while (true) {
//				try {
//					String s = reader.readLine();
//					if ("exit".equals(s.trim())) {
//						reader.close();
//						writer.close();
//						break;
//					}
//					writer.write(s);
//
//				} catch (IOException e) {
//
//				}
//			}
//		}
//	}

//	class OutputWriter extends Thread {
//		PipedReader reader = null;
//
//		public OutputWriter(PipedReader reader) {
//			this.reader = reader;
//		}
//
//		@Override
//		public void run() {
//			try {
//				PrintWriter writer = new PrintWriter(new FileWriter(
//						"pipedOut.txt"), true);
//				BufferedReader consoleReader = new BufferedReader(reader);
//				while (true) {
//					String s = consoleReader.readLine();
//					if (s == null) {
//						reader.close();
//						writer.close();
//						return;
//					}
//					writer.println(s);
//
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}

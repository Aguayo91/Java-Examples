package com.studytrails.nio;

import static java.security.AccessController.doPrivileged;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import sun.security.action.GetPropertyAction;

public class FileLockExampleFile1 {
	/**
	 * File Locks may be mandatory or advisory. When an operating system
	 * implements advisory locking, if provides information about locks on a
	 * particular file to any process that asks for it, however it does not
	 * enforce locking. Operating systems that implement mandatory locking
	 * enforce locks and do not provide permission to a process if another
	 * process has a lock on the file. File locks are held by the jvm process
	 * and locking works only across processes and not across threads
	 * 
	 * Files locks may be shared or exclusive. two processes wishing to read
	 * data from a file may both acquire their own shared locks. This allows
	 * both of them to read data from the file (could be same region too). An
	 * exclusive lock by a process does not allow any other process to acquire a
	 * lock on the file. The exclusive lock has to wait till the shared locks
	 * are released
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws IOException,
			InterruptedException {
		// create a file in the temp directory
		Path tempDir = Paths.get(doPrivileged(new GetPropertyAction(
				"java.io.tmpdir")));
		File file = new File(tempDir.toAbsolutePath() + File.separator
				+ "testLocking.txt");
		if (file.exists())
			file.delete();
		file.createNewFile();
		// now lets try to acquire an exclusive lock on the file
		// get a file channel
		FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
		// get an exclusive lock on this channel
		FileLock lock = fileChannel.lock();
		// write a character and then sleep
		fileChannel
				.write(Charset.defaultCharset().encode(CharBuffer.wrap("a")));
		fileChannel.force(false);
		// hold the lock for 20 secs
		Thread.sleep(20000);
		lock.release();

	}
}

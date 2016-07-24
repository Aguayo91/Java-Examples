package com.studytrails.nio;

import static java.security.AccessController.doPrivileged;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;

import sun.security.action.GetPropertyAction;

public class FileLockExampleFile2 {
	public static void main(String[] args) throws IOException,
			InterruptedException {

		// A test file for locking has been created in FileLockExampleFile1.
		// Please run that file before running this.
		Path tempDir = Paths.get(doPrivileged(new GetPropertyAction(
				"java.io.tmpdir")));
		File file = new File(tempDir.toAbsolutePath() + File.separator
				+ "testLocking.txt");
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		FileChannel fileChannel = rf.getChannel();

		// let us try to get a lock. FileLockExampleFile1 has an exclusive lock
		// so this call will block till FileLockExampleFile1 releases lock
		System.out.println("Trying to acquire lock");
		FileLock lock = fileChannel.lock();
		// FileLockExampleFile1 has release lock.
		System.out.println("file lock acquired");
		lock.release();

	}
}

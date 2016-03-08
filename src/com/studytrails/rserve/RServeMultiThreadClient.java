package com.studytrails.rserve;

public class RServeMultiThreadClient {
	public static void main(String[] args) {
		RServeMultiThread thread1 = new RServeMultiThread(1000);
		RServeMultiThread thread2 = new RServeMultiThread(1000);
		RServeMultiThread thread3 = new RServeMultiThread(1000);
		RServeMultiThread thread4 = new RServeMultiThread(1000);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

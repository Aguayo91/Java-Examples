package com.studytrails.java.util.collections;

import java.util.Vector;

public class VectorThreadExample
{
	public static void main(String[] args) throws InterruptedException
	{
		Vector<String> v1 = new Vector<String>();
		vectorWriter writer = new vectorWriter(v1, "A", 1000);
		vectorWriter writer2 = new vectorWriter(v1, "B", 998);
		writer.start();
		writer2.start();
		writer.join();
		writer2.join();
		System.out.println(v1);
	}
}

class vectorWriter extends Thread
{
	public Vector<String> vector;
	public String a;
	public long msecs;

	public vectorWriter(Vector<String> input, String a, long msecs)
	{
		this.vector = input;
		this.a = a;
		this.msecs = msecs;
	}

	public void run()
	{
		for (int i = 0; i < 10; i++) {
			vector.add(a);
			try {
				Thread.sleep(msecs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(a + "-->" + vector);
		}

	}
}

/*
B-->[A, B]
A-->[A, B, B]
B-->[A, B, B, A]
A-->[A, B, B, A, B]
B-->[A, B, B, A, B, A]
A-->[A, B, B, A, B, A, B]
B-->[A, B, B, A, B, A, B, A]
A-->[A, B, B, A, B, A, B, A, B]
B-->[A, B, B, A, B, A, B, A, B, A]
A-->[A, B, B, A, B, A, B, A, B, A, B]
B-->[A, B, B, A, B, A, B, A, B, A, B, A]
A-->[A, B, B, A, B, A, B, A, B, A, B, A, B]
B-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A]
A-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B]
B-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B, A]
A-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B]
B-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A]
A-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B]
B-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A]
A-->[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A]
[A, B, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A, B, A]*/

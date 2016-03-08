package com.studytrails.patterns.java.singleton;

public class SingletonExample3
{
	private static SingletonExample3 singleton;
	private SingletonExample3()
	{
	}
	public static synchronized SingletonExample3 getInstance()
	{
		if (singleton == null)
			singleton = new SingletonExample3();
		return singleton;
	}
}

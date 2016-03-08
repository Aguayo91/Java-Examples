package com.studytrails.patterns.java.singleton;

public class SingletonExample
{
	public static SingletonExample singleton;
	protected SingletonExample()
	{
	}
	public static SingletonExample getInstance()
	{
		if (singleton == null)
			singleton = new SingletonExample();
		return singleton;
	}
}

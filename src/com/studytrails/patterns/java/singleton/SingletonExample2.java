package com.studytrails.patterns.java.singleton;

public class SingletonExample2
{
	public static SingletonExample2 singleton;
	static {
		singleton = new SingletonExample2();
	}
	private SingletonExample2()
	{
	}
}

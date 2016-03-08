package com.studytrails.patterns.java.singleton;

public class SingletonPattern4
{
	private SingletonPattern4()
	{
	}
	public static SingletonPattern4 getInstance()
	{
		return SingletonInner.singleton;
	}
	public static class SingletonInner
	{
		static SingletonPattern4 singleton = new SingletonPattern4();
	}
}

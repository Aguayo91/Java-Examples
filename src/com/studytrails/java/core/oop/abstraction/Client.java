package com.studytrails.java.core.oop.abstraction;

public class Client {
	public static void main(String[] args) {
		Animal cat = new Cat();
		Animal dog = new Dog();
		System.out.println(cat.getDiet()); // print "Cat Diet"
		System.out.println(dog.getDiet()); // print "Dog Diet"
	}
}

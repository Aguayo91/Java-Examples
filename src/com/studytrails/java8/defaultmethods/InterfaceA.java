package com.studytrails.java8.defaultmethods;

public interface InterfaceA {

	default void methodB() {
		System.out.println("InterfaceA.methodB()");
	}

}

class classA implements InterfaceA {
	// @Override
	// public void methodB() {
	// System.out.println("classA.methodB()");
	// InterfaceA.super.methodB();
	// }
}

abstract class ClassA3 implements InterfaceA {
	public abstract void methodB();
}

interface InterfaceB {
	default void methodB() {
		System.out.println("InterfaceB.methodB()");
	}
}

class ClassAB implements InterfaceA, InterfaceB {

	public void methodB() {
		System.out.println("classAB.methodB()");
		InterfaceA.super.methodB();
		InterfaceB.super.methodB();
	}

}

class ClassA2 extends classA implements InterfaceA {
}

class classAA2 extends ClassA3 implements InterfaceA {

	public void methodB() {
		System.out.println("classAA2.methodB()");
		// InterfaceA.super.methodB(); // illegal, cannot bypass a more specific
		// override from classA22
	}

}

class ClassABA extends ClassAB implements InterfaceA {
	@Override
	public void methodB() {
		System.out.println("classABA.methodB()");
		super.methodB();
	}
}

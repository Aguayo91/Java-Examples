package com.studytrails.java8.lambdas;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class Example {

	public static void main(String[] args) {
		Example ex = new Example();
		// use a method from an object
		ex.oper(ex::add, 1, 2);
		ex.oper((a, b) -> ex.add(a, b), 1, 2);
		// use a static method from a class
		ex.oper(Example::mul, 1, 2);
		ex.oper((a, b) -> Example.mul(a, b), 1, 1);
		// use an instance method from a Class
		ex.operS(String::toLowerCase, "STRING");
		ex.operS(s->s.toLowerCase(), "STRING");
		
		System.out.println(ex.operC(()->{ return new GregorianCalendar();}));
		System.out.println(ex.operC(GregorianCalendar::new));

	}

	public int add(int a, int b) {
		return a + b;
	}

	public static int mul(int a, int b) {
		return a * b;
	}

	public String lower(String a) {
		return a.toLowerCase();
	}

	public void printDate(Date date) {
		System.out.println(date);
	}

	public void oper(IntBinaryOperator operator, int a, int b) {
		System.out.println(operator.applyAsInt(a, b));
	}

	public void operS(Function<String, String> stringOperator, String a) {
		System.out.println(stringOperator.apply(a));
	}

	public GregorianCalendar operC(Supplier<GregorianCalendar> supplier) {
		return supplier.get();
	}

}

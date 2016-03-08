package com.studytrails.java8.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda8Example2 {

	public static void main(String[] args) {

		 Runnable someFunction = () -> System.out.println("test");
		// Runnable anotherFunction = () -> {
		// System.out.println("First statement");
		// System.out.println("Secong Statement");
		// };
//		BinaryOperator<Long> operator = (x, y) -> x + y;
//		Lambda8Example2 example2 = new Lambda8Example2();
//		example2.useOperator(operator);
		
//		Supplier<String> supplier1 = () -> "String1";
//		Supplier<String> supplier2 = () -> "String2";
//		printSuppliedString(supplier1);
//		printSuppliedString(supplier2);
		
//		Function<String, String> function = x -> x.toUpperCase();
//		Function<String, String> function2 = x -> x.toLowerCase();
//		convertString(function);
//		convertString(function2);
		
//		 Consumer<String> function = x -> System.out.println(x);
//		 Consumer<String> function2 = x -> System.out.println(x.toLowerCase());
//		 consumeString(function, "StringA");// prints StringA
//		 consumeString(function2,"StringA");// prints stringa
		 
		 Predicate<Double> function = x -> x > 10;
		 Predicate<Double> function2 = x -> x < -10;
		 
		 System.out.println(function.test(new Double(9)));// prints false
		 System.out.println(function2.test(new Double(-20)));// prints true
		
	}
	
	public static void testValue(Predicate<Double> predicate, Double d){
		predicate.test(d);
	}
	
	public static void consumeString(Consumer<String> consumer, String x) {
		consumer.accept(x);
	}
	
	public static void printSuppliedString(Supplier<String> supplier){
		System.out.println(supplier.get());
	}
	
	public static void convertString(Function<String, String> function){
		System.out.println(function.apply("StRaNgE"));
	}

	public void useOperator(BinaryOperator<Long> operator) {
		long a = 1;
		long b = 2;
		System.out.println(operator.apply(a, b));
	}
}

package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void printEven(List<Integer> list) {
		for (Integer i : list) {
			if (i % 2 == 0)
				System.out.print(i + " | ");
		}
		System.out.println();
	}

	public static void printOdd(List<Integer> list) {
		for (Integer i : list) {
			if (i % 2 != 0)
				System.out.print(i + " | ");
		}
		System.out.println();
	}

	public static void printBy4(List<Integer> list) {
		for (Integer i : list) {
			if (i % 4 == 0)
				System.out.print(i + " | ");
		}
		System.out.println();
	}

	public static void print(List<Integer> list, Cond condition) {
		for (Integer i : list) {
			if (condition.test(i))
				System.out.print(i + " | ");
		}
		System.out.println();
	}
	
	public static void printWithStream(List<Integer> list, Predicate<Integer> condition) {
		list.stream()
			.filter(condition)
			.parallel()
			.sorted(Comparator.reverseOrder())
			.map(i-> i + " | ")
			.forEach(System.out::print);
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0, 1, 4, 5, 2, 3, 6, 7, 8, 9);
		
		printWithStream(list, i-> i%2== 0);
		
		/*
		 * new CondEven().print(); Cond.print2(); print(list, new CondEven());
		 * print(list, new Cond() {
		 * 
		 * @Override public boolean test(Integer i) { Cond.print2(); return i % 4 == 0;
		 * } });
		 * 
		 * print(list, (Integer i) ->{ return i % 4 == 0; } );
		 * 
		 * print(list, i ->i % 4 == 0);
		 */
	}

}

@FunctionalInterface
interface Cond {
	boolean test(Integer i);
	
	default void print() {
		System.out.println("hello");
	}
	
	static void print2() {
		System.out.println("hello2");
	}
	
}

class CondEven implements Cond {

	@Override
	public boolean test(Integer i) {
		return i % 2 == 0;
	}

}

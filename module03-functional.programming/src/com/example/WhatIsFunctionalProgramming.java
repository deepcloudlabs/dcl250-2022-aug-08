package com.example;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class WhatIsFunctionalProgramming {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// List<Integer> numbers= List.of(4,8,10,23,47,52,63);
		var numbers= List.of(4,8,10,23,47,52,63);
		// external loop
		var sumOfCubes = 0;
		for (var number : numbers) {
			if (number % 2 == 0) {
				var cube = number * number * number;
				sumOfCubes += cube;
			}
		}
		System.out.println("Sum of cubes in numbers is %d".formatted(sumOfCubes));
		// functional programming: Java SE 8 
		// functions: i) higher-order function (filter, map, reduce,...) 
		//           ii) pure-function (ifEven, toCube, toSum, ...): Functional Interface (SAM)
		//               a. lambda expression -> anonymous class
		//               b. method reference (::)
		var x = 42; // primitive value
		var origin = new Point(0, 0); // object
		// Collection API --> Stream API -> Filter/Map/Reduce
		// internal loop
		Predicate<Integer> ifEven = u -> u%2 == 0; // lambda expression
		Function<Integer,Integer> toCube = v -> v*v*v;
		// BinaryOperator<Integer> toSum = (sum, u) -> sum + u; 
		BinaryOperator<Integer> toSum = Integer::sum; // method reference
		var stream = numbers.stream(); // Flow API: method chain (HoF) -> pure function
		if (numbers.size() > 10_000_000)
			stream = stream.parallel(); // Java SE 7 : Fork/Join Framework
		sumOfCubes = // single statement -> one-liner
		stream.filter(Fun::isEven) // HoF
		       .map(toCube) // HoF
		       .reduce(toSum) // HoF
		       .get(); 
		// FP -> i) Abstraction Level ii) Multi-core Programming
		
	}

}

class Compatibility implements Fun {

	@Override
	public int fun(int u) {
		   return 4 * u - 2;
	}
	
}

interface Fun {
	// 1. public static -> FP -> Utility Pure Function (Java SE 8)
   public static boolean isEven(int v) {
	   return getModule(2,v) == 0;
   }	
   public static boolean isOdd(int v) {
	   return getModule(2,v) == 1;
   }	
   // 2. default method (Java SE 8)
   default int fun(int u) {
	   return getDouble(u) + 4;
   }
   // 3. private static method (Java SE 9)
   private static int getModule(int mod,int value) {
	   return value % mod;
   } 
   // 4. private method (Java SE 9)
   private int getDouble(int value) {
	   return 2 * value;
   }
}

class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
package com.example;

public class StudyInterface {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Animal animal = new Spider(); // var: Java 10 -> local variable
		var x = 40 + 2. * 10; // x -> double
//		if(animal instanceof B) { // Error: Animal and B 
//			
//		}
		if(animal instanceof Pet) { // Error: Animal and B 
			
		}
	}

}

// Java 17: sealed classes/interfaces
abstract class Vehicle {
	private String identity;

	public Vehicle(String identity) {
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}

final class Car extends Vehicle {
	private int seats;

	public Car(String identity, int seats) {
		super(identity);
		this.seats = seats;
	}

	public int getSeats() {
		return seats;
	}
	
}

sealed interface Service permits A,B,C {
	void doService();
}

final class A implements Service {

	@Override
	public void doService() {
	}
	
}

final class B implements Service {
	
	@Override
	public void doService() {
	}
	
}

non-sealed class C implements Service {
	
	@Override
	public void doService() {
	}
	
}

abstract interface Pet {
	// has no attribute
	// has no constructor
	// has no concrete method until java 8
	// all methods are abstract
	/* implicit: public abstract */ void play();
}


abstract class Animal {
	private int legs = 4; // instance variable

	public Animal(int legs) {
		this.legs = legs;
	}
	
	public void walk() { // concrete -> has a body
		System.out.println("Animal (%d legs) is walking now...".formatted(legs));
	}
	
	public abstract void eat(); // abstract -> has no implementation
}

class Spider extends Animal {

	public Spider() {
		super(8);
	}

	@Override
	public void eat() {
		System.out.println("Spider is eating now...");
	}
	
}

class Cat extends Animal implements Pet {
	public Cat() {
		super(4);
	}
	
	@Override
	public void eat() {
		System.out.println("Cat is eating now...");
	}

	@Override
	public void play() {
		System.out.println("Cat is playing now...");
	}
	
}

// multiple inheritance -> diamond problem -> data
interface AA { } // has no data
interface BB extends AA {}
interface CC extends AA {}
interface DD extends BB, CC {} // multiple inheritance

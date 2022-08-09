package com.example.instof;

import java.util.List;
import java.util.Objects;

public class StudyInstanceof {

	public static void main(String[] args) {
		var animals = List.of(new Spider(),new Cat(),new Fish(),new Cat(), new Fish());
		for (var animal : animals) {
			animal.walk();
			if (animal instanceof Pet pet && Objects.nonNull(pet)) { // Guard
				// var pet = (Pet) animal; // SAFE
				pet.play();
			}
		}

	}

}

interface Pet {
	default void play() {
		System.out.println("Pet is playing...");
	}
}

abstract class Animal {
	public void walk() {
		System.out.println("Animal is walking...");
	}
}

class Spider extends Animal {}
class Cat extends Animal implements Pet {}
class Fish extends Animal implements Pet {}

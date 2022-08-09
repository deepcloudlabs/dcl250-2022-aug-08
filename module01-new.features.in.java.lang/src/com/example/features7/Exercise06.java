package com.example.features7;

import java.io.IOException;

public class Exercise06 {

	public static void main(String[] args) {
		var res1 = new PreciousResource(1);
		var res2 = new PreciousResource(2);
		var res3 = new PreciousResource(3);
		try {
			throw new IllegalArgumentException("Something is wrong!");
		} catch (Exception e) {
			System.err.println("Error: %s".formatted(e.getMessage()));
			for (var t : e.getSuppressed()) {
				System.err.println(t.getMessage());
			}
		} finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.err.println("Error while closing the resource #1: %s".formatted(e.getMessage()));
			} finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.err.println("Error while closing the resource #2: %s".formatted(e.getMessage()));
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.err.println("Error while closing the resource #3: %s".formatted(e.getMessage()));
					}
				}
			}
		}
	}

}

package com.example.features7;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x = 42; // base 10
		System.out.println(x);
		int y = 042; // base 8 -> 4 * 8 + 2 = 34
		System.out.println(y);
		int z = 0x42; // base 16 -> 4 * 16 + 2 = 66
		System.out.println(z);
		int w = 0b11_00_01_01; // base 2 -> base 16 (0xC5) = 66
		System.out.println(w);
		int u = 1_000_000_000;
		double pi = 3.14_15_16;
	}

}

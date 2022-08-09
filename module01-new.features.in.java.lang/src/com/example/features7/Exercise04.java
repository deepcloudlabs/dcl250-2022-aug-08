package com.example.features7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise04 {

	public static void main(String[] args) {
		// Multi-catch
		try {
			FileInputStream fis = new FileInputStream(new File("src", "from.csv"));
			FileOutputStream fos = new FileOutputStream(new File("src", "to.csv"));
			byte buffer[] = new byte[1024];
			var bytes = 0;
			do {
				bytes = fis.read(buffer);
				fos.write(buffer, 0, bytes);
			} while (bytes > 0);
		} catch (IllegalArgumentException | IOException e) {
			System.err.println("Error: %s".formatted(e.getMessage()));
		} catch( ArithmeticException | NullPointerException e) {
			System.err.println("Error: %s".formatted(e.getMessage()));			
		}

	}

}

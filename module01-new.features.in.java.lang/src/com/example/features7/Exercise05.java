package com.example.features7;

import java.io.IOException;

public class Exercise05 {

	@SuppressWarnings("finally")
	public static int fun() {
		try {
			return 42; // a
		} finally {
			return 108; // b
		} // (108+42)/2 // c
	}  
	public static void main(String[] args) {
		// try-with-resources
		System.out.println(fun());
		try( // resource leak free
				var res1 = new PreciousResource(1);
				var res2 = new PreciousResource(2);
				var res3 = new PreciousResource(3);
		) {
		  throw new IllegalArgumentException("Something is wrong!");	
		}catch(Exception e) { 
			System.err.println("Error: %s".formatted(e.getMessage()));
			for (var t : e.getSuppressed()) {
				System.err.println("%s: %s".formatted(t.getClass().getSimpleName(),t.getMessage()));
			}
		}
			

		
	}

}

class PreciousResource implements AutoCloseable {
	private int id;
	
	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws IOException {
		System.err.println("Closing the resource (%d)...".formatted(id));
		throw new RuntimeException("Ooops (%d) !".formatted(id));
	}
	
} 
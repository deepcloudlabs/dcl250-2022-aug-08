package com.example.features7;

public class Exercise03 {

	public static void main(String[] args) {
		// x: byte,short,int, char, Enum
		String x = "Monday"; // since Java 7
		boolean weekend = true;
		switch(x) {
		  case "Monday","Tuesday","Wensday","Thursday","Friday": 
			weekend = false;
			break;
		  default:
			  weekend = true;
		}
		System.out.println(weekend);

	}

}

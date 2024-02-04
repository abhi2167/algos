package com.ds.codewars.stringrotation;

import java.util.ArrayList;

public class StringRotation {

	public static void main(String[] args){
		System.out.println(shiftedDiff("ecoffe","coffee")); //alaab abalba ecoffeecoffe coffeecoffee
		ArrayList a;													  //coffeecoffee ecoffe
		//Collections.rotate()
			
	}
	
	public static int shiftedDiff(String first, String second){
		if(String.valueOf(first).equals(second))
			return 0;
		else if(first.length() != second.length())
			return -1;
		else if((first+first).indexOf(second) != -1) {
			System.out.println((second+second).indexOf(first));
			System.out.println((first+first).lastIndexOf(second));
			return -1;
		}
		return -1;
	  }
	
}

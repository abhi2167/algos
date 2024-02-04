package com.ds.codewars.frogjumps;

public class FrogJumping {

	public static void main(String[] args) {
		solution(new int[] { 1, 2, 1, 5 });
	}

	public static int solution(int[] a) {
	    if(a.length < 1) return -1;                      // get rid of that degenerate case
	    boolean[] b = new boolean[a.length];
	    int index = 0;                                   // where my frog woke up
	    int count = 0;                                   // variable reserved for return value, counts number of jumps
	    while(true) {
	      if(index < 0 || index > a.length - 1) break;   // note the index being out of bound implies frog is now free
	      if(b[index]) return -1;                        // if the frog has already been here it is a bad sign, surely stuck
	      b[index] = true;                               // the frog makes a note to self that it has been here
	      index += a[index];                             // jump
	      count++;
	    }
	    return count;
	  }
}

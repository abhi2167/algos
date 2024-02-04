package com.ds.leetcode;

/***
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1
 */
public class ReverseInteger {
	
	public static void main(String[] args) {
		ReverseInteger rv = new ReverseInteger();
		// 1463847412
		System.out.println(Integer.MAX_VALUE);
		System.out.println("Result is :: " + rv.reverse(1463847412));
	}

    public int reverse(int x) {
    	int reverse = 0;
    	int num = x;
    	int rem;
    	while(num != 0) {
    		rem = num % 10;
    		num = num/10;
    		if((reverse) > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE/10 && rem > 7)
    				|| reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE && rem < -8)) {
    			return 0;
    		} else {
    			reverse = reverse * 10 + rem;
    		}
    	}
        return reverse;
    }
    
}

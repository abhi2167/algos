package com.ds.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author abinay.pingili
 *
 */
public class StringToIntAtoi {
	
	// 48 - 57
	public static void main(String[] args) {
		StringToIntAtoi sa = new StringToIntAtoi();
		String s = "   -421 with ";
		System.out.println("Result is myAtoi " + sa.myAtoi(s));
		System.out.println("Result is myAtoi2 " + sa.myAtoi2(s));
	}
	
	Set<Character> allowedChars = new HashSet<>();

	{
		allowedChars.add(' ');
		allowedChars.add('+');
		allowedChars.add('-');
		allowedChars.add('0');
		allowedChars.add('1');
		allowedChars.add('2');
		allowedChars.add('3');
		allowedChars.add('4');
		allowedChars.add('5');
		allowedChars.add('6');
		allowedChars.add('7');
		allowedChars.add('8');
		allowedChars.add('9');
		
	}
	
	public int myAtoi(String s) {
		int i = 0;
		double result = 0;
		boolean isNegative = false;
		
		
 		while(i < s.length()) {
			char ch = s.charAt(i);
			if(!allowedChars.contains(ch)) {
				break;
			}
			if(ch == '-' || ch == '+') {
				allowedChars.remove('-');
				allowedChars.remove('+');
				allowedChars.remove(' ');
				isNegative = ch == '-';
			} else if(ch != ' '){
				allowedChars.remove('-');
				allowedChars.remove('+');
				allowedChars.remove(' ');
				int temp = s.charAt(i) - '0';
				result = result*10 + temp;
			}
			i++;
		}
        return (int) (isNegative ? result * -1 : result);
    }
	
	public int myAtoi2(String s) {
		
		int result = 0;
		boolean isNegative = false;
		
		int i = 0;
 		while(i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
 		
 		if(i < s.length() && s.charAt(i) == '-') {
 			isNegative = true;
 			i++;
 		} else if(i < s.length() && s.charAt(i) == '+') {
 			i++;
 		}
 		
 		while(i < s.length() && Character.isDigit(s.charAt(i))) {
 			int temp = s.charAt(i) - '0';
 			if((result > Integer.MAX_VALUE/10 
 					|| (result == Integer.MAX_VALUE/10 && temp > Integer.MAX_VALUE %  10))) {
 				return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
 			}
 			result = result * 10 + temp;
 			i++;
 		}
        return isNegative ? result * -1 : result;
    }
}


/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 

Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
Example 2:

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:

Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
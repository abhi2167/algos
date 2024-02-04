package com.ds.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {
	
	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		String s = "MCMXCIV";
		System.out.println("Result is :: "+ rti.romanToInt(s));
		System.out.println("Result is :: "+ rti.romanToInt2(s));
	}

	static Map<Character,Integer> romanToIntValue = new HashMap<>();
	
	static {
		romanToIntValue.put('I', 1);
		romanToIntValue.put('V', 5);
		romanToIntValue.put('X', 10);
		romanToIntValue.put('L', 50);
		romanToIntValue.put('C', 100);
		romanToIntValue.put('D', 500);
		romanToIntValue.put('M', 1000);
	}
	
    public int romanToInt(String s) {
        int result = 0;
        for(int i=0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	result += romanToIntValue.get(ch);
        	if(i != 0) {
        		char prevCh = s.charAt(i-1);
            	if((ch == 'V' || ch == 'X') && prevCh == 'I') {
            		result -= romanToIntValue.get(prevCh) * 2;
            	}
            	if((ch == 'L' || ch == 'C') && prevCh == 'X') {
            		result -= romanToIntValue.get(prevCh) * 2;
            	}
            	if((ch == 'D' || ch == 'M') && prevCh == 'C') {
            		result -= romanToIntValue.get(prevCh) * 2;
            	}
        	}
        }
        return result;
    }
    
    public int romanToInt2(String s) {
        int result = 0;
        for(int i=s.length()-1; i >= 0; i--) {
        	int currentNum = romanToIntValue.get(s.charAt(i));
        	result += currentNum;
        	if(i != s.length()-1) {
        		int nextNum = romanToIntValue.get(s.charAt(i+1));
            	if(nextNum > currentNum) {
            		result -= currentNum * 2;
            	}
        	}
        }
        return result;
    }
    
}

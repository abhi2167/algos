package com.ds.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999
 */
public class IntToRoman {
	
	public static void main(String[] args) {
		IntToRoman itr = new IntToRoman();
		int num = 17837;
		System.out.println(itr.intToRoman(num));
		System.out.println(itr.intToRoman2(num));
		System.out.println(itr.intToRoman3(num));
	}
	
	static Map<Integer,String> intToRomanValue = new HashMap<>();
	static int divisors[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	
	static {
		intToRomanValue.put(1, "I");
		intToRomanValue.put(5, "V");
		intToRomanValue.put(10, "X");
		intToRomanValue.put(50, "L");
		intToRomanValue.put(100, "C");
		intToRomanValue.put(500, "D");
		intToRomanValue.put(1000, "M");
		intToRomanValue.put(4, "IV");
		intToRomanValue.put(9, "IX");
		intToRomanValue.put(40, "XL");
		intToRomanValue.put(90, "XC");
		intToRomanValue.put(400, "CD");
		intToRomanValue.put(900, "CM");
	}

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        List<Integer> digits = new ArrayList<>();
        int rem;
        int multiplier = 1;
        while(num != 0) {
        	rem = num % 10;
        	digits.add(rem * multiplier);
        	multiplier *= 10;
        	num = num/10;
        }
    	System.out.println(digits);
        for(int i = digits.size() - 1; i >=0; i--) {
        	result.append(getRomanValue(digits.get(i)));
        }
        return result.toString();
    }
    
    private String getRomanValue(int n) {
    	StringBuilder result = new StringBuilder();
    	int quotient = n/1000;
    	if(intToRomanValue.containsKey(n) ) {
    		result.append(intToRomanValue.get(n));
    		return result.toString();
    	}
    	if(quotient >=1 ) {
    		while(quotient >= 1) {
    			result.append("M");
    			n = n - 1000;
    			quotient--;
    		}
    	}
    	quotient = n/500;
    	if(quotient >=1 ) {
    		while(quotient >= 1) {
    			result.append("D");
    			n -= 500;
    			quotient--;
    		}
    	}
    	quotient = n/100;
    	if(quotient >=1 ) {
    		while(quotient >= 1) {
    			result.append("C");
    			n -= 100;
    			quotient--;
    		}
    	}
    	quotient = n/50;
    	if(quotient >=1 ) {
    		while(quotient >= 1) {
    			result.append("L");
    			n -= 50;
    			quotient--;
    		}
    	}
    	quotient = n/10;
    	if(quotient >=1 ) {
    		while(quotient >= 1) {
    			result.append("X");
    			n -= 10;
    			quotient--;
    		}
    	}
    	quotient = n/5;
    	if(quotient >=1 ) {
    		while(quotient >= 1) {
    			result.append("V");
    			n -= 5;
    			quotient--;
    		}
    	}
    	quotient = n/1;
    	if(quotient >=1 ) {
    		while(quotient >= 1) {
    			result.append("I");
    			n -= 1;
    			quotient--;
    		}
    	}
    	return result.toString();
    }
    
    public String intToRoman2(int num) {
        StringBuilder result = new StringBuilder();
        List<Integer> digits = new ArrayList<>();
        int rem;
        int multiplier = 1;
        while(num != 0) {
        	rem = num % 10;
        	digits.add(rem * multiplier);
        	multiplier *= 10;
        	num = num/10;
        }
        for(int i = digits.size() - 1; i >=0; i--) {
        	result.append(getRomanValue2(digits.get(i)));
        }
        return result.toString();
    }
    
    private String getRomanValue2(int n) {
        StringBuilder result = new StringBuilder();
    	if(intToRomanValue.containsKey(n) ) {
    		result.append(intToRomanValue.get(n));
    		return result.toString();
    	}
    	int quotient = 0;
    	for(int i=0; i < divisors.length; i++) {
    		quotient = n/divisors[i];
    		while(quotient >= 1) {
    			result.append(intToRomanValue.get(divisors[i]));
    			n = n - divisors[i];
    			quotient--;
    		}
    	}
    	return result.toString();
    }
    
    private String intToRoman3(int n) {
    	StringBuilder result = new StringBuilder();
    	int count = 0;
    	for(int i=0; i < divisors.length && n != 0; i++) {
    		while(n - divisors[i] >= 0) {
    			result.append(intToRomanValue.get(divisors[i]));
    			n = n - divisors[i];
    			count++;
    		}
        	if((divisors[i] == 1 && n - divisors[i] >= 0)) {
        		result.append(intToRomanValue.get(divisors[i]));
        		count++;
        	}
    	}
    	System.out.println(count);
    	System.out.println(result.length());
    	return result.toString();
    }

	private String intToRoman4(int n) {
		StringBuilder result = new StringBuilder();
		List<Integer> values = Stream.of(1000, 900, 500, 400, 100, 90, 50, 40, 10,9,5,4,1).collect(Collectors.toList());
		Map<Integer, String> intToString = new HashMap<>();
		intToString.put(1000, "M");
		intToString.put(900, "CM");
		intToString.put(500, "D");
		intToString.put(400, "CD");
		intToString.put(100, "C");
		intToString.put(90, "XC");
		intToString.put(50, "L");
		intToString.put(40, "XL");
		intToString.put(10, "X");
		intToString.put(9, "IX");
		intToString.put(5, "V");
		intToString.put(4, "IV");
		intToString.put(1, "I");
		int num = n;
		for(int i = 0; i < values.size(); i++) {
			while(values.get(i) <= num) {
				num -= values.get(i);
				result.append(intToString.get(values.get(i)));
			}
		}
		return result.toString();
	}

}

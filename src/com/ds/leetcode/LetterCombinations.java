package com.ds.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 17. Letter Combinations of a Phone Number
Medium

10866

705

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinations {
	
	private static Map<Character, String> letters = new HashMap<>();
	private static List<String> combinations = new ArrayList<>();
	
	private static String phoneDigits = "";
	
	static {
		letters.put('2', "abc");
		letters.put('3', "def");
		letters.put('4', "ghi");
		letters.put('5', "jkl");
		letters.put('6', "mno");
		letters.put('7', "pqrs");
		letters.put('8', "tuv");
		letters.put('9', "wxyz");
	}
	
	public static void main(String[] args) {
		System.out.println("Result :: "+ letterCombinations("234"));
	}

	public static List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0) {
			return Collections.emptyList();
		}
		phoneDigits = digits;
		backtrack(0,new StringBuilder());
		return combinations;
	}
	
	public static void backtrack(int index, StringBuilder path) {
		if(path.length() == phoneDigits.length()) {
			combinations.add(path.toString());
			return;
		}
		String chars = letters.get(phoneDigits.charAt(index));
		for(char ch : chars.toCharArray()) {
			path.append(ch);
			backtrack(index+1, path);
			path.deleteCharAt(path.length()-1);
		}
	}
}

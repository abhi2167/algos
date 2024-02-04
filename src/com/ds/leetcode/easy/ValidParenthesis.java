package com.ds.leetcode.easy;

import java.util.Stack;

/**
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 *
 */
public class ValidParenthesis {
	
	public static void main(String[] args) {
		ValidParenthesis v = new ValidParenthesis();
		String s = "{[]}(){}[][]";
		System.out.println("Result is "+ v.isValid(s));
	}
	
	public boolean isValid(String s) {
		if(s.length() <= 1 || s.length()%2 == 1)
			return false;
		
		Stack<Character> stack = new Stack();
		int i=0;
		while(i < s.length()) {
			char ch = s.charAt(i);
			System.out.println("char " + ch + " i " + i);
			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
				i++;
			}
			else if(!stack.isEmpty()
					&& ((ch == ']' && stack.pop() == '[')
						|| (ch == ')' && stack.pop() == '(')
						|| (ch == '}' && stack.pop() == '{'))) {
					i++;
			} else {
				return false;
			}
		}
		return stack.isEmpty();
        
    }

}

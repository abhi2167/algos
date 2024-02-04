package com.ds.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 *
 */
public class GenerateParenthesis {
	
	public static void main(String[] args) {
		GenerateParenthesis p = new GenerateParenthesis();
		System.out.println("Result is :: " + p.generateParenthesis(3));
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        //generateAll(new char[2 * n], 0, combinations);
        backtrack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }
	
	 
	 
	public void generateAll(char[] current, int pos, List<String> result) {
		System.out.println("pos " + pos + " " + Arrays.toString(current));
        if (pos == current.length) {
            if (valid(current)) {
            	System.out.println("valid pattern");
            	result.add(new String(current));
            }
                
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
    
    
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}

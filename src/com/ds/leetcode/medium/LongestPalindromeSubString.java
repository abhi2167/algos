package com.ds.leetcode.medium;

import java.util.Arrays;

/**
 * 
 * Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 *
 */
public class LongestPalindromeSubString {
	
	public static void main(String[] args) {
		LongestPalindromeSubString l = new LongestPalindromeSubString();
		String s = "abbcde";
		//System.out.println("Result is :: "+ l.longestPalindrome_BF(s));
		System.out.println("Result is :: "+ l.longestPalindrome_DC(s, 0 , s.length()-1));
		System.out.println("Bottom UP Result :: " + l.longestPalindrome_DP_Bottom_up(s));
	}
	
	public String longestPalindrome_DC(String s, int start, int end) {
		if(start > end)
			return "";
		if(start == end)
			return s.substring(start,end+1);
		String s3 = "";
		if(s.charAt(start) == s.charAt(end) ) {
			int remainingLen = end - start - 1;
			String palindrome = longestPalindrome_DC(s, start+1, end-1);
			if(remainingLen == palindrome.length()) {
				s3= s.substring(start, end+1);
			}
		}
		String s1 = longestPalindrome_DC(s, start+1, end);
		String s2 = longestPalindrome_DC(s, start, end-1);
		return returnMaxStr(s3, s1, s2);
    }

	private String returnMaxStr(String s3, String s1, String s2) {
		if(s3.length() >= s1.length() && s3.length() >= s2.length()) {
			return s3;
		} else if(s2.length() >= s3.length() && s2.length() >= s1.length()) {
			return s2;
		} else {
			return s1;
		}
	}
	
	public String longestPalindrome_DP_Bottom_up(String s) {
		boolean [][] dp = new boolean[s.length()+1][s.length()+1];
		int start = 0;
		int end = 0;
		for(int row=dp.length-2; row >=0; row--) {
			for(int col=1; col < dp.length -1; col++) {
				if(row > col)
					dp[row][col] = false;
				else if(row == col)
					dp[row][col] = true;
				else {
					if(dp[row+1][col-1] && s.charAt(row) == s.charAt(col)) {
						dp[row][col] = true;
						start = row;
						end = col;
					}
				}
			}
		}
		
		System.out.println(s.substring(start, end+1));
		for(int i=0; i < dp.length; i++)
			System.out.println(Arrays.toString(dp[i]));
		return s.substring(start, end+1);
    }
	
	
	public String longestPalindrome_BF(String s) {
		String maxStr = "";
		for(int i = 0; i < s.length(); i++) {
			for(int j=i; j <= s.length(); j++) {
				String temp = s.substring(i, j);
				if(isPalindrome(temp) && temp.length() > maxStr.length()) {
					maxStr = temp;
				}
			}
		}
		return maxStr;
    }
	
	private boolean isPalindrome(String s) {
		int i=0;
		int j = s.length()-1;
		while(i <= j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}

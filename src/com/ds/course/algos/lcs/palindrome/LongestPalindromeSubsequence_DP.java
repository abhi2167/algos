package com.ds.course.algos.lcs.palindrome;

import java.util.Arrays;

public class LongestPalindromeSubsequence_DP {
	
	public static void main(String[] args) {
		LongestPalindromeSubsequence_DP l = new LongestPalindromeSubsequence_DP();
		String s = "AMEEWMEA";
		int [][] dp = new int[s.length()][s.length()];

		System.out.println("Result :: "+ l.findPalindromeLcs(s, 0, s.length()-1, dp));
		System.out.println(l.counter);
		System.out.println("Bottom up result "+ l.findPalindromeLcs_BottomUp(s));
	}
	
	private int counter = 0;

	private int findPalindromeLcs(String s, int start, int end, int [][]dp) {
		counter++;
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return 1;
		}
		if(dp[start][end] != 0) {
			return dp[start][end];
		}
		int c1 = 0;
		if(s.charAt(start) == s.charAt(end)) {
			c1 = 2 + findPalindromeLcs(s, start+1, end-1, dp);
		}
		int c2 = findPalindromeLcs(s, start, end-1, dp);
		int c3 = findPalindromeLcs(s, start+1, end, dp);
		dp[start][end] = Math.max(c1, Math.max(c2, c3));
		for(int i=0; i < dp.length; i++)
			System.out.println(Arrays.toString(dp[i]));
		System.out.println("\n================\n");
		return dp[start][end];
	}
	
	private int findPalindromeLcs_BottomUp(String s) {
		int [][]dp = new int[s.length()+1][s.length()+1];
		for(int row=dp.length-2; row >=0; row--) {
			for(int col=1; col < dp[row].length-1; col++) {
				if(row > col) {
					dp[row][col] = 0;
				} else if(row == col) {
					dp[row][col] = 1;
				} else {
					int c1=0, c2=0, c3=0;
					if(s.charAt(row) == s.charAt(col)) {
						c1 = 2 + dp[row+1][col-1];
					}
					c2 = dp[row+1][col];
					c3 = dp[row][col-1];
					dp[row][col] = Math.max(c1, Math.max(c2, c3));
				}
			}
		}
		return dp[0][dp.length-2];
	}
	
}

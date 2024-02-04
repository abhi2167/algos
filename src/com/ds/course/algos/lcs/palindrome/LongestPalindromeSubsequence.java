package com.ds.course.algos.lcs.palindrome;

public class LongestPalindromeSubsequence {
	
	public static void main(String[] args) {
		LongestPalindromeSubsequence l = new LongestPalindromeSubsequence();
		String s = "AMEEWMEA";
		System.out.println("Result :: "+ l.findPalindromeLcs(s, 0, s.length()-1));
		System.out.println(l.counter);
		counter = 0;
		int dp[][] = new int[s.length()][s.length()];
		System.out.println("Result dp :: "+ l.findPalindromeLcs_dp(s, 0, s.length()-1, dp));
		System.out.println(l.counter);
		System.out.println("Result dp bottom up:: "+ l.findPalindromeLcs_dp_bottom_up(s));
	}

	private static int counter = 0;
	
	private int findPalindromeLcs(String s, int start, int end) {
		counter++;
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return 1;
		}
		int c1 = 0;
		if(s.charAt(start) == s.charAt(end)) {
			c1 = 2 + findPalindromeLcs(s, start+1, end-1);
		}
		int c2 = findPalindromeLcs(s, start, end-1);
		int c3 = findPalindromeLcs(s, start+1, end);
		return Math.max(c1, Math.max(c2, c3));
	}

	private int findPalindromeLcs_dp(String s, int start, int end, int [][]dp) {
		counter++;
		if(start > end) {
			return 0;
		}
		if(start == end) {
			dp[start][end] = 1;
			return 1;
		}
		if(dp[start][end] == 0) {
			int c1 = 0;
			if(s.charAt(start) == s.charAt(end)) {
				c1 = 2 + findPalindromeLcs_dp(s, start+1, end-1, dp);
			}
			int c2 = findPalindromeLcs_dp(s, start, end-1, dp);
			int c3 = findPalindromeLcs_dp(s, start+1, end, dp);
			dp[start][end] = Math.max(c1, Math.max(c2, c3));
			printArray(dp);
		}
		return dp[start][end];
	}

	private int findPalindromeLcs_dp_bottom_up(String s) {
		int [][] dp = new int[s.length()+1][s.length()+1];
		int rows = s.length()+1;
		int cols = s.length()+1;
		for(int i=rows-2; i>=0; i--) {
			for(int j=1; j < cols-1; j++) {
				if(j < i) {
					dp[i][j] = 0;
				} else if (i == j) {
					dp[i][j] = 1;
				} else {
					int c1 = 0;
					if(s.charAt(i) == s.charAt(j)) {
						c1 = 2 + dp[i+1][j-1];
					}
					int c2 = dp[i+1][j];
					int c3 = dp[i][j-1];
					dp[i][j] = Math.max(c1, Math.max(c2, c3));
				}
			}
		}
		printArray(dp);
		return dp[0][dp.length-2];
	}

	private static void printArray(int[][] dp) {
		System.out.println("\n=========================================");
		for (int i = 0; i < dp.length; i++) {
			System.out.println("");
			for(int j = 0; j < dp[i].length; j++) {
				System.out.print("\t"+ dp[i][j]);
			}
		}
	}
}

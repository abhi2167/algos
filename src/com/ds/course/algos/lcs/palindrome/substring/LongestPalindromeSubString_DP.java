package com.ds.course.algos.lcs.palindrome.substring;

import java.util.Arrays;

public class LongestPalindromeSubString_DP {

	public static void main(String[] args) {
		LongestPalindromeSubString_DP l = new LongestPalindromeSubString_DP();
		String s = "babad";
		int [][]dp = new int[s.length()][s.length()];
		System.out.println("Result :: "+ l.findPalindromeSubstring(s, 0, s.length()-1, dp));
		System.out.println("Result Bottom up "+ l.findPalindromeSubstring_BottomUp(s));

	}

	private int findPalindromeSubstring(String s, int start, int end, int[][] dp) {
		System.out.println(" start " + start + " end " + end + " dp " + dp[start][end]);
		if(start > end)
			return 0;
		if(start == end)
			return 1;
		if(dp[start][end] != 0) {
			return dp[start][end];
		}
		int c1 = 0;
		if(s.charAt(start) == s.charAt(end)) {
			int remainingLength = end - start - 1;
			if(findPalindromeSubstring(s, start+1, end-1, dp) == remainingLength) {
				c1 = 2 + remainingLength;
			}
		}
		int c2 = findPalindromeSubstring(s, start, end-1, dp);
		int c3 = findPalindromeSubstring(s, start+1, end, dp);
		dp[start][end] = Math.max(c1, Math.max(c2, c3));
		//System.out.println(" start " + start + " end " + end + " dp " + dp[start][end]);
		printArray(dp);
		System.out.println("\n=================\n");
		return dp[start][end];
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






	private int findPalindromeSubstring_BottomUp(String s) {
		int [][] dp = new int[s.length()+1][s.length()+1];
		for(int row=dp.length-2; row >=0; row--) {
			for(int col=1; col < dp.length -1; col++) {
				if(row > col)
					dp[row][col] = 0;
				else if(row == col)
					dp[row][col] = 1;
				else {
					int c1=0, c2=0, c3=0;
					if(s.charAt(row) == s.charAt(col)) {
						int remainingLen = col-row-1;
						if(remainingLen == dp[row+1][col-1])
							c1 = 2 + remainingLen;
					}
					c2 = dp[row+1][col];
					c3 = dp[row][col-1];
					dp[row][col] = Math.max(c1, Math.max(c2, c3));
					System.out.println("row " + row + " Col " + col);
				}
			}
		}
		
		for(int i=0; i < dp.length; i++)
			System.out.println(Arrays.toString(dp[i]));
		return dp[0][s.length()-2];
	}
}

package com.ds.course.algos.lcs;

import java.util.Arrays;

public class LongestCommonSubSequence_DP {

	public static void main(String[] args) {
		
		LongestCommonSubSequence_DP l = new LongestCommonSubSequence_DP();
		String s1 = "elephant";
		String s2 = "eretpat";
		int [][]dp = new int[s1.length()+1][s2.length()+1];
		System.out.println("Result :: "+ l.findLcs(s1, s2, 0, 0, dp));
		System.out.println("counter "+ l.counter);
		System.out.println("Bottom up result " + l.findLcs_bottomUp(s1, s2));

	}

	private int counter = 0;
	private int findLcs(String s1, String s2, int i1, int i2, int[][] dp) {
		counter++;
		if(i1 >= s1.length() || i2 >= s2.length()) {
			return 0;
		}
		if(dp[i1][i2] != 0) {
			return dp[i1][i2];
		}
		int c1 = 0;
		if(s1.charAt(i1) == s2.charAt(i2)) {
			c1 = 1 + findLcs(s1, s2, i1+1, i2+1, dp);
		}
		int c2 = findLcs(s1,s2,i1,i2+1, dp);
		int c3 = findLcs(s1,s2,i1+1, i2, dp);
		dp[i1][i2] =  Math.max(c1, Math.max(c2, c3));
		for(int i=0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println("\n============================ \n");
		return dp[i1][i2];
	}
	
	private int findLcs_bottomUp(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0)
			return 0;
		int rowLength = s1.length()+1;
		int colLength = s2.length() + 1;
		int [][]dp = new int[rowLength][colLength];
		for(int row = 0; row < dp.length; row++) {
			dp[row][colLength-1] = 0;
 		}
		for(int col=0; col < colLength-1; col++) {
			dp[rowLength-1][col] = 0;
		}
//		for(int i=0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		for(int col = colLength-2; col >=0; col--) {
			for(int row = rowLength-2; row >=0; row--) {
				int c1 =0, c2 = 0, c3 = 0;
				if(s1.charAt(row) == s2.charAt(col)) {
					c1 = 1 + dp[row+1][col+1];
				}
				c2 = dp[row+1][col];
				c3 = dp[row][col+1];
				dp[row][col] = Math.max(c1, Math.max(c2, c3));
			}
		}
		return dp[0][0];
	}
}

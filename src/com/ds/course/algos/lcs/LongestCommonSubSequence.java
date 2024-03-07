package com.ds.course.algos.lcs;

import java.util.Arrays;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		
		LongestCommonSubSequence l = new LongestCommonSubSequence();
		String s1 = "elephantt";
		String s2 = "eretpatet";
		System.out.println("Result :: "+ l.findLcs(s1, s2, 0, 0));
		System.out.println("Counter " + l.counter);
		counter = 0;

		int [][]dp = new int[s1.length()+1][s2.length()+1];
		System.out.println("\nResult :: "+ l.findLcs_dp(s1, s2, 0, 0, dp));
		System.out.println("\nCounter " + l.counter);
		System.out.println("\nResult :: "+ l.findLcs_dp_bottom_up(s1, s2));
		System.out.println("\nResult :: "+ l.findLcs_bu(s1, s2));

	}

	private int findLcs_bu(String s1, String s2) {
		if(s1.length() > s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		int previous[] = new int[s1.length()+1];

		for(int i=s2.length()-1; i>=0; i--) {
			int current[] = new int[s1.length()+1];
			for(int j = s1.length()-1; j >= 0; j--) {
				if(s1.charAt(i) == s2.charAt(j)) {
					current[j] = 1 + previous[j+1];
				} else {
					current[j] = Math.max(previous[j], current[j+1]);
				}
			}
			previous = current;
		}
		return previous[0];
	}
	private static int counter = 0;

	private int findLcs(String s1, String s2, int i1, int i2) {
		counter++;
		if(i1 >= s1.length() || i2 >= s2.length()) {
			return 0;
		}
		int c1 = 0;
		if(s1.charAt(i1) == s2.charAt(i2)) {
			c1 = 1 + findLcs(s1, s2, i1+1, i2+1);
		}
		int c2 = findLcs(s1,s2,i1,i2+1);
		int c3 = findLcs(s1,s2,i1+1, i2);
		return Math.max(c1, Math.max(c2, c3));
	}

	private int findLcs_dp_bottom_up(String s1, String s2) {
		int rows = s2.length() + 1;
		int cols = s1.length() + 1;
		int [][]dp = new int[rows][cols];
		for(int i= rows-1; i >=0 ; i--) {
			dp[i][cols-1] = 0;
		}
		for(int i=cols-1; i>=0; i--) {
			dp[rows-1][i] = 0;
		}
		for(int i = rows-2; i >=0; i-- ) {
			for (int j = cols-2; j >=0; j--) {
				int c1 =0;
				if(s1.charAt(j) == s2.charAt(i)) {
					c1 = 1 + dp[i+1][j+1];
				}
				dp[i][j] = Math.max(c1, Math.max(dp[i+1][j], dp[i][j+1]));
			}
		}
		printArray(dp);
		return dp[0][0];
	}

	private int findLcs_dp(String s1, String s2, int i1, int i2, int[][] dp) {
		counter++;
		if(i1 >= s1.length() || i2 >= s2.length()) {
			dp[i1][i2] = 0;
			return 0;
		}
		if (dp[i1][i2] == 0) {
			int c1 = 0;
			if(s1.charAt(i1) == s2.charAt(i2)) {
				c1 = 1 + findLcs_dp(s1, s2, i1+1, i2+1, dp);
			}
			int c2 = findLcs_dp(s1,s2,i1,i2+1, dp);
			int c3 = findLcs_dp(s1,s2,i1+1, i2, dp);
			dp[i1][i2] = Math.max(c1, Math.max(c2, c3));
			printArray(dp);
		}
		return dp[i1][i2];
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

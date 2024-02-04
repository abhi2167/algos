package com.ds.course.algos.convertstring;

import java.util.Arrays;

public class ConvertStringS1ToS2_DP {
	
	public static void main(String[] args) {
		ConvertStringS1ToS2_DP c = new ConvertStringS1ToS2_DP();
		String s1 = "table";
		String s2 = "tbres";
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		System.out.println("\n  Result = " + c.convertString(s1, s2, 0, 0, dp));
		System.out.println("\n  Result = " + c.convertString_bottomUp(s1, s2));
	}

	private int convertString_bottomUp(String s1, String s2) {
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i = s2.length(); i >= 0; i--) {
			dp[s1.length()][i] = s2.length() - i;
		}
		for(int i = s1.length(); i >= 0; i--) {
			dp[i][s2.length()] = s1.length() - i;
		}
		for(int i = s1.length()-1; i >=0 ; i--) {
			for (int j = s2.length()-1; j >=0; j--) {
				//System.out.println("i : "+ i + " j "+ j);
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i+1][j+1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
				}
				//printArray(dp);
			}
		}
		printArray(dp);
		return dp[0][0];
	}

	private int convertString(String s1, String s2, int i1, int i2, int[][] dp) {
		if(dp[i1][i2] == 0) {
			if(i1 >= s1.length()) {
				dp[i1][i2] = s2.length() - i2;
			} else if(i2 >= s2.length()) {
				dp[i1][i2] = s1.length() - i1;
			} else if(s1.charAt(i1) == s2.charAt(i2)) {
				dp[i1][i2] = convertString(s1, s2, i1 + 1, i2 + 1, dp);
			} else {
				int insert = 1 + convertString(s1, s2, i1+1, i2, dp);
				int delete = 1 + convertString(s1, s2, i1, i2 + 1, dp);
				int replace = 1 + convertString(s1, s2, i1+1, i2+1, dp);
				System.out.println("\n i1: " + i1 + " i2: "+ i2);
				System.out.println("\n insert: " + insert + " replace: "+ replace + " delete: " + delete);
				dp[i1][i2] = Math.min(insert, Math.min(delete, replace));
			}
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

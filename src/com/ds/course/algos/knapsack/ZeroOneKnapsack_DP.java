package com.ds.course.algos.knapsack;

import java.util.Arrays;

public class ZeroOneKnapsack_DP {
	
	public static void main(String[] args) {
		ZeroOneKnapsack_DP p = new ZeroOneKnapsack_DP();
		
		int []weights = {3,1,5,2};
		int [] profits = {31,26,72,17};
		
		
		int [][] dp = new int[5][8];
		for(int i=0; i < dp.length; i++) {
			for(int j=0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
			
		}
		System.out.println("\n Result :: " + p.knapsack(7, weights, profits, 0, dp));
		
		System.out.println(p.knapsack_BottomUp(7,weights, profits));
		
	}

	private int knapsack(int capacity, int []weights, int[] profits, int currentIndex, int[][] dp) {
		if(capacity < 0) {
			return 0;
		}
		if(currentIndex >= weights.length) {
			return 0;
		}
		if(dp[currentIndex][capacity] != -1) {
			return dp[currentIndex][capacity];
		}
		int p1 = 0;
		if(weights[currentIndex] <= capacity)
			p1 = profits[currentIndex] + knapsack(capacity - weights[currentIndex], weights, profits, currentIndex + 1, dp);
		int p2 = knapsack(capacity, weights, profits, currentIndex+1, dp);
		dp[currentIndex][capacity] = Math.max(p1, p2);
		for(int i =0; i < dp.length;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println("\n\n =================");
		return dp[currentIndex][capacity];
	}
	
	private int knapsack_BottomUp(int capacity, int []weights, int []profits) {
		int numOfRows = profits.length + 1;
		int columns = capacity + 1;
		int [][]dp = new int[profits.length+1][columns];
		for(int row=0; row < dp.length;row++) {
			dp[row][0] = 0;
		}
		for(int col=0; col < capacity+1;col++) {
			dp[dp.length-1][col] = 0;
		}
		for(int row = dp.length-2; row >=0; row--) {
			for(int col=1; col < columns; col++) {
				int p1 = 0;
				int p2 = 0;
				if(weights[row] <= col) {
					p1 = profits[row] + dp[row+1][col - weights[row]];
				}
				p2 = dp[row+1][col];
				dp[row][col] = Math.max(p1, p2);
			}
		}
		return dp[0][capacity];
	}
}

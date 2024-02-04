package com.ds.course.algos.knapsack;

import java.util.Arrays;

public class ZeroOneKnapsack_Dp2 {
	
	public static void main(String[] args) {
		ZeroOneKnapsack_Dp2 p = new ZeroOneKnapsack_Dp2();


		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };

		System.out.println("Value :: Weight");
		int dp[][] = new int[profits.length+1][7+1];
		System.out.println("\n Result :: " + p.knapsack(7, profits, weights, 0, dp));
		System.out.println("\n Result :: " + p.knapsack_dp(7, profits, weights));
	}


	private int knapsack_dp(int capacity, int []profits, int[] weights) {
		int [][] dp = new int[profits.length+1][capacity+1];
		for(int i=0; i < dp.length; i++) {
			dp[i][0] = 0;

		}
		for(int i=0; i < capacity+1;i++) {
			dp[profits.length][i] = 0;
		}
		printArray(dp);
		for(int i = profits.length-1; i >= 0; i--) {
			for(int j=1; j <= capacity; j++) {
				int p1 = 0;
				if(weights[i] <= j)
					p1 = profits[i] + dp[i+1][j-weights[i]];
				int p2 = dp[i+1][j];
				dp[i][j] = Math.max(p1, p2);
			}
		}
		printArray(dp);
		return dp[0][capacity];
	}
	private int knapsack(int capacity, int []profits, int[] weights, int i, int [][] dp) {

		if(capacity <= 0 || i >= profits.length) {
			dp[i][capacity] = 0;
			return 0;
		}
		if (dp[i][capacity] == 0) {
			int p1 = 0;
			if(weights[i] <= capacity)
				p1 = profits[i] + knapsack(capacity - weights[i], profits, weights,i+1, dp);
			int p2 = knapsack(capacity, profits, weights, i+1, dp);
			dp[i][capacity] = Math.max(p1, p2);
			printArray(dp);
		}
		return dp[i][capacity];
	}


	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)  //Base case
			return 0;

		int numberOfRows = profits.length + 1;// adding a dummy row to avoid array index issues
		int[][] dp = new int[numberOfRows][capacity + 1];// Create a 2D Array to store all the results

		for (int i = 0; i < numberOfRows; i++) { // Insert 0 in 1st column as it is dummy column to avoid array index issues
			dp[i][0] = 0;
		}

		for (int i = 0; i <= capacity; i++) {// Insert 0 in last row as it is dummy column to avoid array index issues
			dp[numberOfRows - 1][i] = 0;
		}

		for (int row = numberOfRows - 2; row >= 0; row--) {
			for (int column = 1; column <= capacity; column++) {
				int profit1 = 0, profit2 = 0;
				if (weights[row] <= column) { // column represents current capacity
					profit1 = profits[row] + dp[row + 1][column - weights[row]];  // Taking current element
				}
				profit2 = dp[row + 1][column]; // Not taking current element
				dp[row][column] = Math.max(profit1, profit2);
			}
		}//end of loop
		return dp[0][capacity];
	}// end of method

//	public static void main(String[] args) {
//		ZeroOneKnapsack_Dp2 ks = new ZeroOneKnapsack_Dp2();
//		int[] profits = { 31, 26, 72, 17 };
//		int[] weights = { 3, 1, 5, 2 };
//		System.out.println(ks.solveKnapsack(profits, weights, 7));
//	}// end of method

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

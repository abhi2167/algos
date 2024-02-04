package com.ds.course.algos.mincost.array;

import java.util.Arrays;

public class TraverseArrayWithMinCostDP {
	
	public static void main(String[] args) {
		TraverseArrayWithMinCostDP m = new TraverseArrayWithMinCostDP();
		int [][] items = {{4,7,8,6,4},{6,7,3,9,2},{3,8,1,2,4},{7,1,7,3,7},{2,9,8,9,3}};
		int [][]dp = new int[items.length][items.length];
		System.out.println("Result :: " + m.minCostToReachEnd(items, items.length-1, items[items.length-1].length-1, dp));
		System.out.println("Bottom Up Result :: " + m.minCostToReachEnd_BottomUp(items));
		System.out.println("Bottom Up Result :: " + m.minCostToReachEnd_DP2(items));
	}


	private int minCostToReachEnd_DP2(int [][]items) {
		int dp[][] = new int[items.length][items.length];
		dp[0][0] = items[0][0];
		for(int row=0; row < items.length; row++) {
			for(int col=0; col < items[row].length; col++) {
				if(row ==0 && col ==0) {
					dp[0][0] = items[0][0];
				} else {
					if(row == 0) {
						dp[0][col] = items[0][col] + dp[0][col-1];
					} else if (col == 0) {
						dp[row][0] = items[row][0] + dp[row-1][0];
					} else {
						dp[row][col] = items[row][col] + Math.min(dp[row-1][col], dp[row][col-1]);
					}
				}
			}
		}
		printArray(dp);
		return dp[items.length-1][items.length-1];
	}




	private int minCostToReachEnd(int [][] items, int i, int j, int[][]dp) {
		if(i == -1 || j== -1)
			return Integer.MAX_VALUE;
		if(i == 0 && j == 0 )
			return items[0][0];
		if(dp[i][j] == 0) {
			int c1 = minCostToReachEnd(items, i-1, j, dp);
			int c2 = minCostToReachEnd(items, i, j-1, dp);
			dp[i][j] = Math.min(c1, c2) + items[i][j];
		}
		printArray(dp);
		return dp[i][j];
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

	private int minCostToReachEnd_BottomUp(int [][] items) {
		int [][]dp = new int[items.length][items[0].length];
		for(int i=0; i < items.length; i++) {
			for(int j=0; j < items[i].length; j++) {
				if(i ==0 && j==0)
					dp[i][j] = items[i][j];
				else if(i-1 == -1)
					dp[i][j] = items[i][j] + dp[i][j-1];
				else if(j-1 == -1)
					dp[i][j] = items[i][j] + dp[i-1][j];
				else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + items[i][j];
				}
			}
		}
		for(int p=0; p < dp.length; p++)
			System.out.println(Arrays.toString(dp[p]));
		return dp[items.length-1][items.length-1];
	}
	
}

package com.ds.course.algos.array.reachlastcell;

public class WaysToReachLastCell {
	
	public static void main(String[] args) {
		WaysToReachLastCell c = new WaysToReachLastCell();
		int [][] arr = {{4,7,1,6},{5,7,3,9},{3,2,1,2},{7,1,6,3}};
		System.out.println("Recusion Result is :: " + c.waysToReachLastCell(arr, arr.length-1, arr.length-1, 25));
		int dp[][] = new int[arr.length][arr.length];
 		System.out.println("Recursion Result is :: " + c.waysToReachLastCell2(arr, arr.length-1, arr.length-1, 25, dp));
	}

	private int waysToReachLastCell2(int[][] items, int row, int col, int cost, int [][]dp) {
		if (cost < 0 ) {
			return 0;
		}
		if(row == 0 && col == 0) {
			return cost == 0 ? 1 : 0;
		}
		if(dp[row][col] == 0) {
			if(row == 0) {
				dp[row][col] = waysToReachLastCell2(items, row, col-1, cost - items[row][col], dp);
				//return dp[row][col];
			} else if(col == 0) {
				dp[row][col] = waysToReachLastCell2(items, row-1, col, cost - items[row][col], dp);
				//return dp[row][col];
			} else {
				int c1 = waysToReachLastCell2(items, row - 1, col, cost - items[row][col], dp);
				int c2 = waysToReachLastCell2(items, row, col - 1, cost - items[row][col], dp);
				dp[row][col] = c1 + c2;
				printArray(dp);
			}
		}
		return dp[row][col];
	}

	/*
	0	0	0	0
	0	0	1	1
	0	0	1	2
	0	1	2	4
	 */

	private static void printArray(int[][] dp) {
		System.out.println("\n=========================================");
		for (int i = 0; i < dp.length; i++) {
			System.out.println("");
			for(int j = 0; j < dp[i].length; j++) {
				System.out.print("\t"+ dp[i][j]);
			}
		}
	}
































	private int waysToReachLastCell(int [][]arr, int i, int j, int cost) {
		if(cost < 0)
			return 0;
		if(i == 0 && j == 0)
			return cost - arr[0][0] == 0 ? 1 : 0;
		if(i == 0)
			return waysToReachLastCell(arr, i, j-1, cost - arr[i][j]);
		if(j == 0)
			return waysToReachLastCell(arr, i-1, j, cost - arr[i][j]);
		int c1 = waysToReachLastCell(arr,i,j-1, cost-arr[i][j]);
		int c2 = waysToReachLastCell(arr, i-1, j, cost-arr[i][j]);
		return c1+c2;
	}

}

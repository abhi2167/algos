package com.ds.course.algos.array.reachlastcell;

import java.util.Arrays;

public class WaysToReachLastCell_DP {
	
	public static void main(String[] args) {
		WaysToReachLastCell_DP c = new WaysToReachLastCell_DP();
		int [][] arr = {{4,7,1,6},{5,7,3,9},{3,2,1,2},{7,1,6,3}};
		System.out.println("Total paths with cost "  + " are " + c.numberOfPaths(arr, arr.length - 1, arr[0].length - 1, 25));
	}
	
	
	public int numberOfPaths(int array[][], int row, int col, int cost) {
		int[][] dp = new int[row + 1][col + 1];
		return numberOfPathsAux(dp, array, row, col, cost);
	}// End of method
	

	public int numberOfPathsAux(int dp[][], int array[][], int row, int col, int cost) {
		if (cost < 0) {// BASE CASE
			return 0;
		}
		if (row == 0 && col == 0) { // BASE CASE
			return (array[0][0] - cost == 0) ? 1 : 0;
		}
		if (dp[row][col] == 0) {// If we have not solved this problem previously, only then solve it
			if (row == 0) { // BASE CASE: If we're at first row, we can only go left
				dp[row][col] = numberOfPaths(array, 0, col - 1, cost - array[row][col]);
			}
			else if (col == 0) { // BASE CASE: if we're at first column, we can only go up
				dp[row][col] = numberOfPaths(array, row - 1, 0, cost - array[row][col]);
			} else {
				int noOfPathsFromPreviousRow = numberOfPaths(array, row - 1, col, cost - array[row][col]); // Find Paths till last Row
				int noOfPathsFromPreviousCol = numberOfPaths(array, row, col - 1, cost - array[row][col]); // Find Paths till last Col
				dp[row][col] = noOfPathsFromPreviousRow + noOfPathsFromPreviousCol;
			}
		} // end of if-else block
		return dp[row][col];
	}// End of method

}

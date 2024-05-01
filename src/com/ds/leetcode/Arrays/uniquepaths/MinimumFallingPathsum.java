package com.ds.leetcode.Arrays.uniquepaths;

import java.util.Arrays;

public class MinimumFallingPathsum {

    public static void main(String[] args) {
        MinimumFallingPathsum m = new MinimumFallingPathsum();
        int [][] grid = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Minimum falling path sum bottom up = " + m.minFallingPathSum(grid));
        System.out.println("Minimum falling path sum top down = " + m.minFallingPathSum_tp(grid));
        System.out.println("Minimum falling path sum bottom up space eff = " + m.minFallingPathSum_eff(grid));
    }

    public int minFallingPathSum_eff(int[][] matrix) {
        int n = matrix.length;
        int dp[] = new int[n];
        if(n == 1) {
            return matrix[0][0];
        }
        int minSum = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++) {
            dp[col] = matrix[0][col];
        }
        for(int row = 1; row < n; row++) {
            for(int col = 0; col < n; col++) {
                int currentEl = matrix[row][col];
                int topEl = dp[col];
                int topPreviousEl = col > 0 ? dp[col-1] : Integer.MAX_VALUE;
                int topNextEl = col < n - 1 ? dp[col+1] : Integer.MAX_VALUE;
                dp[col] = currentEl + Math.min(topPreviousEl, Math.min(topEl, topNextEl));
                if( row == n -1) {
                    minSum = Math.min(minSum, dp[col]);
                }
            }
        }
        return minSum;
    }


    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        if(n == 1) {
            return matrix[0][0];
        }
        int minSum = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }
        for(int row = 1; row < n; row++) {
            for(int col = 0; col < n; col++) {
                int currentEl = matrix[row][col];
                int topEl = dp[row-1][col];
                int topPreviousEl = col > 0 ? dp[row-1][col-1] : Integer.MAX_VALUE;
                int topNextEl = col < n - 1 ? dp[row-1][col+1] : Integer.MAX_VALUE;
                dp[row][col] = currentEl + Math.min(topPreviousEl, Math.min(topEl, topNextEl));
                if( row == n -1) {
                    minSum = Math.min(minSum, dp[row][col]);
                }
            }
        }
        return minSum;
    }

    public int minFallingPathSum_tp(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix.length];
        if(matrix.length == 1) {
            return matrix[0][0];
        }
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int minSum = Integer.MAX_VALUE;
        for(int col = 0; col < matrix.length; col++) {
            minSum = Math.min(minSum, minFallingPathSum_tp(matrix, matrix.length-1, col, dp));
        }
        return minSum;
    }

    private int minFallingPathSum_tp(int[][] matrix, int row, int col, int[][] dp) {
        if(row == 0) {
            return matrix[row][col];
        }
        if(dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int currentEl = matrix[row][col];
        int topEl = minFallingPathSum_tp(matrix, row-1, col, dp);
        int topPreviousEl = col > 0 ? minFallingPathSum_tp(matrix, row-1, col-1, dp) : Integer.MAX_VALUE;
        int topNextEl = col < matrix.length - 1 ? minFallingPathSum_tp(matrix, row-1, col+1, dp) : Integer.MAX_VALUE;

        return dp[row][col] = currentEl + Math.min(topPreviousEl, Math.min(topEl, topNextEl));
    }
}

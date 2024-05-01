package com.ds.leetcode.Arrays.uniquepaths;

public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Minimum path sum top down = " + m.minPathSum(grid));
        System.out.println("Minimum path sum bottom up = " + m.minPathSum_bu(grid));
        System.out.println("Minimum path sum bottom up efficient = " + m.minPathSum_bu_eff(grid));
    }

    public int minPathSum_bu_eff(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[] = new int [cols];
        int previousLeft = 0;
        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(row == 0 && col == 0) {
                    dp[col] = grid[row][col];
                } else if (row == 0) {
                    dp[col] = grid[row][col] + previousLeft;
                } else if (col == 0) {
                    dp[col] = grid[row][col] + dp[col];
                } else {
                    dp[col] = grid[row][col] + Math.min(dp[col], previousLeft);
                }
                previousLeft = dp[col];
            }
        }
        return dp[cols-1];
    }

    public int minPathSum_bu(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][] = new int [rows][cols];
        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                } else if (row == 0) {
                    dp[row][col] = grid[row][col] + dp[row][col-1];
                } else if (col == 0) {
                    dp[row][col] = grid[row][col] + dp[row-1][col];
                } else {
                    dp[row][col] = grid[row][col] + Math.min(dp[row-1][col], dp[row][col-1]);
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][] = new int [rows][cols];
        return minPathSum(grid, rows-1, cols-1, dp);

    }

    private int minPathSum(int[][] grid, int row, int col, int[][] dp) {
        if(row == 0 && col == 0) {
            return grid[row][col];
        }
        if(dp[row][col] != 0) {
            return dp[row][col];
        }
        if(row == 0) {
            return dp[row][col] = grid[row][col] + minPathSum(grid, row, col-1, dp);
        }
        if (col == 0) {
            return dp[row][col] = grid[row][col] + minPathSum(grid, row-1, col, dp);
        }
        return dp[row][col] = grid[row][col] + Math.min(minPathSum(grid, row, col-1, dp), minPathSum(grid, row-1, col, dp));
    }
}

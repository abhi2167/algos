package com.ds.leetcode.Arrays.uniquepaths;

import java.util.Arrays;

public class UniquePaths2 {

    public static void main(String[] args) {
        UniquePaths2 u = new UniquePaths2();
        int [][]obstacleGrid = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
        System.out.println("number of unique paths with obstacles bottom up = " + u.uniquePathsWithObstacles(obstacleGrid));
        System.out.println("number of unique paths with obstacles top down = " + u.uniquePathsWithObstacles_tp(obstacleGrid));
        System.out.println("number of unique paths with obstacles bottom up efficient = " + u.uniquePaths_eff(obstacleGrid));
    }

    public int uniquePaths_eff(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        int []dp = new int[n];
        int maxPathsFromLeft = 0;
        for(int i = 0; i < m; i++) {
            maxPathsFromLeft = 0;
            for(int j = 1; j < n; j++) {
                dp[0] = obstacleGrid[i][0] == 1 ? 0 : 1;
                if (obstacleGrid[i][j] == 0) {
                    if(j == 0) {
                        dp[j] = dp[j-1] + maxPathsFromLeft;
                        maxPathsFromLeft = dp[j];
                    }
                }
            }
        }
        return dp[n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    if(i > 0) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if(j > 0) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }
        for(int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles_tp(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        int ways =  uniquePathsWithObstacles_tp(obstacleGrid, m-1, n-1, dp);
        for(int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return  ways;
    }

    public int uniquePathsWithObstacles_tp(int[][] obstacleGrid, int m , int n, int[][] dp) {

        if(m == 0 && n == 0) {
            return dp[m][n] = obstacleGrid[0][0] == 1 ? 0 : 1;
        }
        if(dp[m][n] != 0) {
            return  dp[m][n];
        }
        if(obstacleGrid[m][n] == 0) {
            if (m > 0) {
                dp[m][n] += uniquePathsWithObstacles_tp(obstacleGrid, m - 1, n, dp);
            }
            if (n > 0) {
                dp[m][n] += uniquePathsWithObstacles_tp(obstacleGrid, m, n - 1, dp);
            }
        }
        return dp[m][n];
    }
}

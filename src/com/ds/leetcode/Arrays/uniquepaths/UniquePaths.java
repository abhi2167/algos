package com.ds.leetcode.Arrays.uniquepaths;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        int m = 3, n =3;
        System.out.println("number of unique paths = " + u.uniquePaths(m, n));
    }

    public int uniquePaths_eff(int m, int n) {
        int []dp = new int[n+1];
        int maxPathsFromRight = 0;
        for(int i = m-1; i>=0; i--) {
            maxPathsFromRight = 0;
            for(int j = n-1; j >=0; j--) {
                if(i == m - 1) {
                   dp[j] = 1;
                   maxPathsFromRight = 1;
                } else {
                    dp[j] = dp[j] + maxPathsFromRight;
                    maxPathsFromRight = dp[j];
                }
            }
        }
        return dp[0];
    }

    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m+1][n+1];
        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j >=0; j--) {
                if( i == m-1 && j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}

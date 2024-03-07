package com.ds.leetcode.Arrays;

public class TribonacciSeries {

    public static void main(String[] args) {
        TribonacciSeries t = new TribonacciSeries();
        System.out.println("nth number of tribonacci series is : " + t.tribonacci(25));
        System.out.println("nth number of tribonacci series is : " + t.tribonacci_bu(0));
        System.out.println("nth number of tribonacci series is : " + t.tribonacci_bu_efficient_space(25));
    }

    public int tribonacci_bu_efficient_space(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int a=0, b = 1, c = 1;
        for(int i=0; i < n-2; i++) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    public int tribonacci_bu(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int []dp = new int[n+1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    public int tribonacci(int n) {
        int []dp = new int[n+1];
        return tribonacci(n, dp);
    }

    public int tribonacci(int n, int[] dp) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = tribonacci(n-3, dp) + tribonacci(n-2, dp) + tribonacci(n-1, dp);
    }
}

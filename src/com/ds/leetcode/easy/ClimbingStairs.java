package com.ds.leetcode.easy;

import java.util.*;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println("Number of ways to  reach top == " + c.climbStairs_tp(3));
        System.out.println("Number of ways to  reach top == " + c.climbStairs_bu(3));
        System.out.println("Number of ways to  reach top == " + c.climbStairs_bfs(3));
    }

    public int climbStairs_tp(int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        return climbStairs_tp(n-2) + climbStairs_tp(n-1);
    }

    public int climbStairs_bu(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[dp.length-1];
    }

    public int climbStairs_bfs(int n) {
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        while(!queue.isEmpty()) {
            int remainder = queue.poll();
            if(remainder == 0) {
                count++;
            }
            if(remainder-1 >= 0) {
                queue.add(remainder-1);
            }
            if(remainder-2 >= 0) {
                queue.add(remainder-2);
            }
        }
        return count;
    }
}

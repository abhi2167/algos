package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class MinCostToClimbStairs {

    public static void main(String[] args) {
        MinCostToClimbStairs o = new MinCostToClimbStairs();
        int [] cost = {10, 15, 20};
        System.out.println("Min cost to climb stairs == " + o.minCostClimbingStairs(cost));
        System.out.println("Min cost to climb stairs bu == " + o.minCostClimbingStairs_bu(cost));
        System.out.println("Min cost to climb stairs bu2 == " + o.minCostClimbingStairs_bu2(cost));
        System.out.println("Min cost to climb stairs bu3 == " + o.minCostClimbingStairs_bu3(cost));
        System.out.println("Min cost to climb stairs bu4 == " + o.minCostClimbingStairs_bu4(cost));
    }

    public int minCostClimbingStairs_bu4(int[] cost) {
        int oneStepBack = 0;
        int twoStepBack = 0;
        for(int i = 2; i <= cost.length; i++) {
            int temp = oneStepBack;
            oneStepBack = Math.min(cost[i-1] + oneStepBack, cost[i-2] + twoStepBack);
            twoStepBack = temp;
        }
        return oneStepBack;
    }

    public int minCostClimbingStairs_bu3(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }
        return dp[dp.length-1];
    }

    public int minCostClimbingStairs_bu(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < dp.length; i++) {
            if(i < cost.length)
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            else
                dp[i] = Math.min(dp[i-1], dp[i-2]);
        }
        return dp[dp.length-1];
    }

    public int minCostClimbingStairs_bu2(int[] cost) {
        int[] dp = new int[cost.length+2];
        dp[dp.length-1] = 0;
        dp[dp.length-2] = 0;
        for(int i = dp.length-3; i >=0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }
        return dp[0];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return minCostClimbingStairs(cost, cost.length, dp);
    }

    private int minCostClimbingStairs(int[] cost, int currentIndex, int[] dp) {
        if(currentIndex == 1 || currentIndex == 0) {
            return cost[currentIndex];
        }
        if(dp[currentIndex] != -1) {
            return dp[currentIndex];
        }
        if(currentIndex == cost.length) {
            return dp[currentIndex] = Math.min(minCostClimbingStairs(cost, currentIndex-1, dp), minCostClimbingStairs(cost, currentIndex-2, dp));
        } else {
            return dp[currentIndex] = cost[currentIndex] + Math.min(minCostClimbingStairs(cost, currentIndex-1, dp), minCostClimbingStairs(cost, currentIndex-2, dp));
        }

    }
}

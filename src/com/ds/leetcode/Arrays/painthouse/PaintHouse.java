package com.ds.leetcode.Arrays.painthouse;

public class PaintHouse {
    public static void main(String[] args) {
        PaintHouse p = new PaintHouse();
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println("Min cost to pain houses top down = " + p.minCost_tp(costs));
        System.out.println("Min cost to pain houses bottom up = " + p.minCost_bu(costs));
    }

    public int minCost_bu(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        int k = 3;
        int dp[][] = new int[costs.length][k];
        for(int color = 0; color < k; color++) {
            dp[0][color] = costs[0][color];
            minCost = Math.min(minCost, dp[0][color]);
        }
        if(costs.length == 1) {
            return minCost;
        }
        minCost = Integer.MAX_VALUE;
        for (int house = 1; house < costs.length; house++) {
            for (int color = 0; color < k; color++) {
                if(color == 0) {
                    dp[house][0] = costs[house][0] + Math.min(dp[house-1][1], dp[house-1][2]);
                } else if( color == 1) {
                    dp[house][1] = costs[house][1] + Math.min(dp[house-1][0], dp[house-1][2]);
                } else {
                    dp[house][2] = costs[house][2] + Math.min(dp[house-1][0], dp[house-1][1]);
                }
                if(house == costs.length-1) {
                    minCost = Math.min(minCost, dp[house][color]);
                }
            }
        }
        return minCost;
    }

    public int minCost_tp(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        int dp[][] = new int[costs.length][3];
        for (int i = 0; i < costs[0].length; i++) {
            minCost = Math.min(minCost, minCost_tp(costs, 0, i, dp));
        }
        return minCost;
    }

    private int minCost_tp(int[][] costs, int house, int color, int[][] dp) {
        if (house == costs.length - 1) {
            return costs[house][color];
        }
        if (dp[house][color] != 0) {
            return dp[house][color];
        }
        if (color == 0) {
            return dp[house][color] = costs[house][color] + Math.min(minCost_tp(costs, house + 1, 1, dp), minCost_tp(costs, house + 1, 2, dp));
        } else if (color == 1) {
            return dp[house][color] = costs[house][color] + Math.min(minCost_tp(costs, house + 1, 0, dp), minCost_tp(costs, house + 1, 2, dp));
        } else {
            return dp[house][color] = costs[house][color] + Math.min(minCost_tp(costs, house + 1, 0, dp), minCost_tp(costs, house + 1, 1, dp));
        }
    }
}

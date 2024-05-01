package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        //int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] days = {1,4,6,9,10,11,12,13,14,15,16,17};
        int[] costs = {3,13,45};
        /*
        f(n) = Min_cost(n) + min(f(n-1))
        f(day, validity) = Min(cost(day)) + min(cost(day+1))
         */
        System.out.println("Minimum cost for tickets for all days top down = " + m.mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        Integer [][]dp = new Integer[days[days.length-1]][days[days.length-1]+30];
        return mincostTickets(days, costs, 0, 0, dp);
    }

    private int mincostTickets(int[] days, int[] costs, int currentDay, int remainingValidity, Integer[][] dp) {
        if(currentDay == days.length) {
            return 0;
        }
        if(dp[currentDay][remainingValidity] != null) {
            return dp[currentDay][remainingValidity];
        }
        if(remainingValidity > 0 && remainingValidity >= days[currentDay]) {
            return dp[currentDay][remainingValidity] = mincostTickets(days, costs, currentDay+1, remainingValidity, dp);
        }
        int minCostDay1Pass = costs[0] + mincostTickets(days, costs, currentDay+1, days[currentDay], dp);
        int minCostDay7Pass = costs[1] + mincostTickets(days, costs, currentDay+1, days[currentDay]+6, dp);
        int minCostDay30Pass = costs[2] + mincostTickets(days, costs, currentDay+1, days[currentDay]+29, dp);
        return dp[currentDay][remainingValidity] = Math.min(minCostDay1Pass, Math.min(minCostDay7Pass, minCostDay30Pass));
    }
}

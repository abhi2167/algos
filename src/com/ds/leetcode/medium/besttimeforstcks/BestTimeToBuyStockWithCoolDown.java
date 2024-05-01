package com.ds.leetcode.medium.besttimeforstcks;

public class BestTimeToBuyStockWithCoolDown {

    public static void main(String[] args) {
        BestTimeToBuyStockWithCoolDown b = new BestTimeToBuyStockWithCoolDown();
        int[] prices = {1,2,3,0,2};
        System.out.println(" max profit top down " + b.maxProfit(prices));
        System.out.println(" max profit bu " + b.maxProfit_bu(prices));
    }

    public int maxProfit_bu(int[] prices) {
        int n = prices.length + 1;
        int dp[][] = new int[n][2];
        dp[n-2][0] = 0;
        dp[n-2][1] = prices[n-2];
        for(int i =n-3; i >=0; i--) {
            for(int h=0; h < 2; h++) {
                int doNothing = dp[i+1][h]; // nextDay WIth and WithoutHolding
                int doSomething;
                if(h == 0) {
                    doSomething =  -prices[i] + dp[i+1][1]; // nextDayWithHolding

                } else {
                    doSomething = prices[i] + dp[i+2][0]; // nextNextDayWithoutHolding
                }
                dp[i][h] = Math.max(doNothing, doSomething);
            }
        }
        return dp[0][0];
    }

    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        return maxProfit(prices, 0, 0, dp);
    }

    public int maxProfit(int[] prices, int currentDay, int holding, int[][] dp) {
        if(currentDay >= prices.length) {
            return 0;
        }
        if(currentDay == prices.length-1) {
            if(holding == 1) {
                return prices[currentDay];
            } else {
                return 0;
            }
        }
        if(dp[currentDay][holding] != 0) {
            return dp[currentDay][holding];
        }
        int doNothing = maxProfit(prices, currentDay+1, holding, dp);
        int doSomething;
        if(holding == 0) {
            doSomething = -prices[currentDay] + maxProfit(prices, currentDay+1, 1, dp);
        } else {
            doSomething = prices[currentDay] + maxProfit(prices, currentDay + 2, 0, dp);
        }
        return dp[currentDay][holding] =Math.max(doNothing, doSomething);
    }

}

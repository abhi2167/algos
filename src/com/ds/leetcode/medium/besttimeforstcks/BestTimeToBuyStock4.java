package com.ds.leetcode.medium.besttimeforstcks;

public class BestTimeToBuyStock4 {
    public static void main(String[] args) {
        BestTimeToBuyStock4 b = new BestTimeToBuyStock4();
        int[] prices = {1,2,3,0,2};
        int k = 2;
        System.out.println(" max profit top down " + b.maxProfit(k, prices));
        System.out.println(" max profit top down " + b.maxProfit_bu(k, prices));
    }

    public int maxProfit_bu(int k, int[] prices) {
        int n = prices.length+1;
        int dp[][][] = new int[n][k+1][2];
        for(int i = n-2; i >=0; i--) {
            for(int j = 1; j <= k; j++) {
                for(int h=0; h < 2; h++) {
                    int doNothing = dp[i+1][j][h];
                    int doSomething;
                    if(h == 0) {
                        doSomething = -prices[i] + dp[i+1][j][1];
                    } else {
                        doSomething = prices[i] + dp[i+1][j-1][0];
                    }
                    dp[i][j][h] = Math.max(doNothing, doSomething);
                }
            }
        }
        return dp[0][k][0];
    }

    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][k + 1][2];
        return maxProfit(k, prices, 0, 0, dp);
    }

    private int maxProfit(int remainingTx, int[] prices, int currentDay, int holding, int[][][] dp) {
        if (remainingTx == 0 || currentDay == prices.length) {
            return 0;
        }
        if (dp[currentDay][remainingTx][holding] == 0) {
            int doNothing = maxProfit(remainingTx, prices, currentDay + 1, holding, dp);
            int doSomething;
            if (holding == 0) {
                doSomething = -prices[currentDay] + maxProfit(remainingTx, prices, currentDay + 1, 1, dp);
            } else {
                doSomething = prices[currentDay] + maxProfit(remainingTx - 1, prices, currentDay + 1, 0, dp);
            }
            dp[currentDay][remainingTx][holding] = Math.max(doNothing, doSomething);
        }
        return dp[currentDay][remainingTx][holding];
    }
}

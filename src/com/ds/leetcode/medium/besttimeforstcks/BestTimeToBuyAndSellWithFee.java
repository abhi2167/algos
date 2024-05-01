package com.ds.leetcode.medium.besttimeforstcks;

public class BestTimeToBuyAndSellWithFee {

    public static void main(String[] args) {
        BestTimeToBuyAndSellWithFee b = new BestTimeToBuyAndSellWithFee();
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println("Best time to buy and sell with fee " + b.maxProfit(prices, fee));
        System.out.println("Best time to buy and sell with fee using state machine approach " + b.maxProfit_state_machine(prices, fee));
    }

    public int maxProfit_state_machine(int[] prices, int fee) {
        int held = -prices[0];
        int free = 0;
        for(int i = 1; i < prices.length; i++) {
            int preSold = free;
            free = Math.max(free, held + prices[i] - fee );
            held = Math.max(held, preSold - prices[i]);
        }
        return free;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length + 1;
        int dp[][] = new int[n][2];
        dp[n-2][0] = 0;
        dp[n-2][1] = prices[n-2] - fee;
        for(int i =n-3; i >=0; i--) {
            for(int h=0; h < 2; h++) {
                int doNothing = dp[i+1][h]; // nextDay WIth and WithoutHolding
                int doSomething;
                if(h == 0) {
                    doSomething =  -prices[i] + dp[i+1][1]; // nextDayWithHolding

                } else {
                    doSomething = prices[i] + dp[i+1][0] - fee; // nextDayWithoutHolding
                }
                dp[i][h] = Math.max(doNothing, doSomething);
            }
        }
        return dp[0][0];
    }
}

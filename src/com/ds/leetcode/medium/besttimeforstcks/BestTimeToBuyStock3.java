package com.ds.leetcode.medium.besttimeforstcks;

public class BestTimeToBuyStock3 {

    public static void main(String[] args) {
        BestTimeToBuyStock3 b = new BestTimeToBuyStock3();
        int [] prices = {3,3,5,0,0,3,1,4};
        System.out.println("max Profit == " + b.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int leftMin = prices[0];
        int rightMax = prices[length-1];
        int leftProfits[] = new int[length];
        int rightProfits[] = new int[length+1];
        for(int i=1; i < length; i++) {
            leftProfits[i] = Math.max(leftProfits[i-1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);

            int r = length - 1 - i;
            rightProfits[i] = Math.max(rightProfits[r+1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);

        }
        int maxProfit = 0;
        for(int i=0; i < length; i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i+1]);
        }
        return  maxProfit;
    }

}

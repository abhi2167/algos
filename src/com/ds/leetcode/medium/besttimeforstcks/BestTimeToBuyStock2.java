package com.ds.leetcode.medium.besttimeforstcks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 */
public class BestTimeToBuyStock2 {
	
	public static void main(String[] args) {
		BestTimeToBuyStock2 b = new BestTimeToBuyStock2();
		int []prices = {7,1,5,3,6,4};
		System.out.println("Result is :: "+ b.maxProfit(prices));
		System.out.println("Result is :: "+ b.maxProfit2(prices));
		System.out.println("Result is :: "+ b.maxProfit3(prices));
		System.out.println("Result is :: "+ b.maxProfit_stack(prices));
	}

	// own implementation that works
	public int maxProfit_stack(int[] prices) {
		int maxProfit = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i < prices.length; i++) {
			while(stack.peekLast() != null && stack.peekLast() >= prices[i]) {
				while(stack.peekLast() != null) stack.pollLast();
			}
			if (stack.peekLast() != null) {
				maxProfit += prices[i] - stack.peekLast();
			}
			stack.offerLast(prices[i]);
		}
		return maxProfit;
	}
	
	public int maxProfit3(int[] prices) {
    	int maxProfit = 0;
    	for(int i = 1; i < prices.length - 1; i++) {
    		if(prices[i] >= prices[i-1]) {
    			maxProfit += prices[i] - prices[i-1];
    		}
    	}
    	return maxProfit; 
    }

    public int maxProfit2(int[] prices) {
    	int maxProfit = 0;
    	int valley = prices[0];
    	int peak = prices[0];
    	int i = 0;
    	while(i < prices.length -1) {
    		while(i < prices.length-1 && prices[i+1] <= prices[i]) {
    			i++;
    		}
    		valley = prices[i];
    		while(i < prices.length-1 && prices[i+1] >= prices[i]) {
    			i++;
    		}
    		peak = prices[i];
    		maxProfit += peak-valley;
    	}
    	return maxProfit; 
    }
    
    public int maxProfit(int[] prices) {
    	if(prices.length == 1) {
    		return 0;
    	}
    	int totalProfit = 0;
    	int maxProfit = 0;
    	int priceDropIndex = 0;
    	int i = 0, j = 1;
    	while(i < prices.length) {
    		maxProfit = 0;
    		while(j < prices.length) {
    			maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
    			if(prices[j] < prices[j-1] && j > i) {
    				priceDropIndex = j;
    				break;
    			} else {
        			j++;
    			}
    		}
    		System.out.println("i "+ i + " maxProfit " + maxProfit);
    		totalProfit += maxProfit;
    		if(j == prices.length) {
    			break;
    		} else {
        		i = Math.max(priceDropIndex, i + 1);
        		j = i + 1;
    		}
    		
    	}
    	return totalProfit; 
    }

	public int maxProfit_tp(int[] prices) {
		Integer dp[][] = new Integer[prices.length][2];
		return maxProfit(prices, 0, 0, dp);
	}

	public int maxProfit(int[] prices, int currentDay, int holding, Integer[][] dp) {
		if(currentDay == prices.length-1) {
			return holding == 1 ? prices[currentDay] : 0;
		}
		if(dp[currentDay][holding] != null) {
			return dp[currentDay][holding];
		}
		int doNothing = maxProfit(prices, currentDay + 1, holding, dp);
		int doSomething;
		if(holding == 0) {
			doSomething = -prices[currentDay] + maxProfit(prices, currentDay+1, 1, dp);
		} else {
			doSomething = prices[currentDay] + maxProfit(prices, currentDay+1, 0, dp);
		}
		return dp[currentDay][holding] = Math.max(doSomething, doNothing);
	}
}

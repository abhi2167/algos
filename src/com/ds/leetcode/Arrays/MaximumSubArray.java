package com.ds.leetcode.Arrays;

public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray m = new MaximumSubArray();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maximum sub array " + m.maxSubArray(nums));
        int[] prices = {7,1,5,3,6,4};
        System.out.println("maximum profit " + m.maxProfit(prices));
    }

    public int maxSubArray(int[] nums) {
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

}

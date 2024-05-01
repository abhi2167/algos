package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class MaximumCircularSubArray {

    public static void main(String[] args) {
        MaximumCircularSubArray m = new MaximumCircularSubArray();
        int [] nums = {2,-2,-1,-4,5,2,1,0};
        System.out.println("maximum sub array " + m.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int totalSum = 0;
        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;
        for(int i=0; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], nums[i]+currentMin);
            minSum = Math.min(minSum, currentMin);
            totalSum += nums[i];
        }
        System.out.println("total sum " + totalSum + " minSum " + minSum + " max Sum " + maxSum);
        return minSum == totalSum ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}

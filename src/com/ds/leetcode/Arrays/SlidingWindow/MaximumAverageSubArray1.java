package com.ds.leetcode.Arrays.SlidingWindow;

public class MaximumAverageSubArray1 {

    public static void main(String[] args) {
        MaximumAverageSubArray1 m = new MaximumAverageSubArray1();
        int k = 4;
        int nums[] = {1,12,-5,-6,50,3};
        System.out.println(" Maximum avg is = " + m.findMaxAverage(nums, k));
        System.out.println(" Maximum avg is = " + m.findMaxAverage2(nums, k));
        System.out.println(" Maximum avg is = " + m.findMaxAverage3(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {

        int currentSum = 0;

        for(int i = 0; i < k-1; i++) {
            currentSum += nums[i];
        }
        int maxSum = Integer.MIN_VALUE;
        int left = 0; int right = k-1;
        while(right < nums.length) {
            currentSum += nums[right];
            while(right - left + 1 >= k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                left++;
            }
            right++;
        }
        return (double) maxSum/k;
    }

    public double findMaxAverage2(int[] nums, int k) {

        double currentSum = 0;
        double maxSum = Integer.MIN_VALUE;
        int left = 0; int right = 0;
        while(right < nums.length) {
            currentSum += nums[right];
            while(right - left + 1 >= k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                left++;
            }
            right++;
        }
        return maxSum/k;
    }

    public double findMaxAverage3(int[] nums, int k) {

        double currentSum = 0;
        for(int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        double maxSum = currentSum;
        for(int i = k; i < nums.length;i++) {
            currentSum += nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum/k;

    }
}

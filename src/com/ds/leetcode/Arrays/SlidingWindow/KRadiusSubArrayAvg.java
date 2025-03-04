package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.Arrays;

public class KRadiusSubArrayAvg {

    public static void main(String[] args) {
        KRadiusSubArrayAvg o = new KRadiusSubArrayAvg();

        int [] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        System.out.println("K radius sub array averages using prefix sum = " + Arrays.toString(o.getAverages(nums, k)));

        System.out.println("K radius sub array averages using sliding sum = " + Arrays.toString(o.getAverages_SlidingWindow(nums, k)));
    }

    public int[] getAverages_SlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int windowSize = 2 * k + 1;
        if(k == 0) {
            return nums;
        }
        int avg[] = new int[n];
        Arrays.fill(avg, -1);
        if(windowSize > n) {
            return avg;
        }
        int windowSum = 0;
        for(int i=0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        avg[k] = windowSum/windowSize;

        for(int i = windowSize; i < n; i++) {
            windowSum = windowSum - nums[i-windowSize] + nums[i];
            avg[i-k] = windowSum/windowSize;
        }

        return avg;
    }
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if(k == 0) {
            return nums;
        }
        int windowSize = 2 * k + 1;
        int kRadiusAvgs [] = new int[n];
        Arrays.fill(kRadiusAvgs, -1);
        if(windowSize > n) {
            return kRadiusAvgs;
        }

        int[] prefix = new int[n+1];
        for(int i=0; i < n;i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }

        for(int i = k; i < n-k; i++) {
            int leftBound = i-k;
            int rightBound = i+k;
            int sum = prefix[rightBound+1] - prefix[leftBound];
            kRadiusAvgs[i] = sum/windowSize;
        }

        return kRadiusAvgs;
    }
}

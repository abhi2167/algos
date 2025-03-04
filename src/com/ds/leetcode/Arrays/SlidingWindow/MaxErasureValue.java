package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxErasureValue {

    public static void main(String[] args) {
        MaxErasureValue o = new MaxErasureValue();
        int[] nums = {4,2,4,5,6};
        System.out.println("Max sum of unique elements sub array = " + o.maximumUniqueSubarray(nums));
        System.out.println("Max sum of unique elements sub array maximumUniqueSubarray_using_prefix_sum = " + o.maximumUniqueSubarray_using_prefix_sum(nums));
    }

    public int maximumUniqueSubarray_using_prefix_sum(int[] nums) {
        int maxSum = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        Map<Integer, Integer> numsFreq = new HashMap<>();
        int[] prefixSum = new int[nums.length+1];
        while(right < nums.length) {
            int currentNum = nums[right];
            prefixSum[right+1] = prefixSum[right] + currentNum;
            while(numsFreq.containsKey(currentNum)) {
                left =
                currentSum -= nums[left];
                numsFreq.put(nums[left], numsFreq.get(nums[left]) - 1);
                left++;
            }
            numsFreq.put(currentNum, right);
            currentSum += currentNum;
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }
        return maxSum;
    }

    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        Map<Integer, Integer> numsFreq = new HashMap<>();
        while(right < nums.length) {
            int currentNum = nums[right];
            numsFreq.put(currentNum, numsFreq.getOrDefault(currentNum, 0)+1);
            currentSum += currentNum;
            while(numsFreq.get(currentNum) > 1) {
                currentSum -= nums[left];
                numsFreq.put(nums[left], numsFreq.get(nums[left]) - 1);
                left++;
            }
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }
        return maxSum;
    }
}

package com.ds.leetcode.Arrays;

public class MinimumSubArrayLengthForTarget {
    public static void main(String[] args) {

        MinimumSubArrayLengthForTarget m = new MinimumSubArrayLengthForTarget();
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(" Result == " + m.minSubArrayLen(target, nums));

    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int currentSum = 0;
        int minElements = Integer.MAX_VALUE;
        while (right < n) {
            currentSum += nums[right];
            while(currentSum >= target) {
                minElements = Math.min(minElements, right-left+1);
                currentSum = currentSum - nums[left];
                left++;
            }
            right++;
        }
        return minElements == Integer.MAX_VALUE ? 0 : minElements;
    }
}

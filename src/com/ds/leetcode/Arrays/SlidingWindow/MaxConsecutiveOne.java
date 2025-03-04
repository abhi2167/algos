package com.ds.leetcode.Arrays.SlidingWindow;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 */
public class MaxConsecutiveOne {

    public static void main(String[] args) {
        MaxConsecutiveOne m = new MaxConsecutiveOne();
        int [] nums = {1,0,1,1,0};
        System.out.println(" Max consecutive one from array = " + m.findMaxConsecutiveOnes(nums));
        System.out.println(" Max consecutive one from array = " + m.findMaxConsecutiveOnes_2(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int zeroCount = 0;
        int firstZeroIndex = -1;
        int secondZeroIndex = -1;
        while(right < nums.length) {
            if(nums[right] == 0) {
                zeroCount++;
                if(zeroCount == 1) {
                    firstZeroIndex = right;
                }
                if(zeroCount == 2) {
                    secondZeroIndex = right;
                }
            }
            if(zeroCount > 1) {
                left = firstZeroIndex+1;
                zeroCount = 1;
                firstZeroIndex = secondZeroIndex;
            }
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }

    public int findMaxConsecutiveOnes_2(int[] nums) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int zeroCount = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                zeroCount++;
            }
            while(zeroCount > 1) {
                zeroCount -= nums[left] == 0 ? 1 : 0;
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }
}

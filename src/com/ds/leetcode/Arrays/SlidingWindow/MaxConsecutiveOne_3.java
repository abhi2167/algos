package com.ds.leetcode.Arrays.SlidingWindow;

public class MaxConsecutiveOne_3 {

    public static void main(String[] args) {
        MaxConsecutiveOne_3 o = new MaxConsecutiveOne_3();
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(" Max consecutive one from array " + o.longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxSequence = 0;
        int zeroCount = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                zeroCount++;
            }
            while(zeroCount > k) {
                zeroCount -= nums[left] == 0 ? 1 : 0;
                left++;
            }
            maxSequence = Math.max(maxSequence, right - left + 1);
            right++;
        }
        return maxSequence;
    }
}

package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class TwoSumLessThanK {
    public static void main(String[] args) {
        TwoSumLessThanK k = new TwoSumLessThanK();
        int[] nums = {34,23,1,24,75,33,54,8};
        int target = 60;
        System.out.println(k.twoSumLessThanK(nums, target));
    }

    private int twoSumLessThanK(int[] nums, int target) {
        int result = -1;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < target) {
                result = Math.max(sum, result);
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}

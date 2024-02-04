package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class TwoSumTwo {
    public static void main(String[] args) {
        TwoSumTwo t = new TwoSumTwo();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(t.twoSumTwo(nums, target)));
    }

    private int[] twoSumTwo(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}

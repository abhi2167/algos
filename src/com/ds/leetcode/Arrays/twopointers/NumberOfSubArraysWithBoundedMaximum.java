package com.ds.leetcode.Arrays.twopointers;

public class NumberOfSubArraysWithBoundedMaximum {

    public static void main(String[] args) {
        NumberOfSubArraysWithBoundedMaximum o = new NumberOfSubArraysWithBoundedMaximum();
        int[] nums = {2,1,4,3};
        int left = 2;
        int right = 3;
        System.out.println("Number of sub array with bounded maximum = " + o.numSubarrayBoundedMax(nums, left, right));
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int count = 0;
        while(r < nums.length) {
            if(nums[r] >= left && nums[r] <= right) {
                count = r-l+1;
                ans += count;
            } else if (nums[r] < left) {
                ans += count;
            } else if(nums[r] > right) {
                l = r+1;
                count=0;
            }
            right++;
        }
        return ans;
    }
}

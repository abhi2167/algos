package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class NumOfSubSequencesWithLessThanSum {

    public static void main(String[] args) {
        NumOfSubSequencesWithLessThanSum o = new NumOfSubSequencesWithLessThanSum();
        int [] nums = {2,3,3,4,6,7};
        int target = 12;
        System.out.println("Num of sub sequences with min/max less than target sum = " + o.numSubseq(nums, target));
    }

    public int numSubseq(int[] nums, int target) {
        int totalSubArrays = 0;
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        for(int left = 0; left < nums.length; left++) {
            int compliment = target - nums[left];
            int rightBound = binSearch(nums, compliment, left) - 1;
            if(rightBound >= left) {
                totalSubArrays += Math.pow(2, rightBound-left);
                totalSubArrays %= mod;
            }

        }
        return totalSubArrays;
    }

    private int binSearch(int[] nums, int compliment, int currentIndex) {
        int left = currentIndex;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= compliment) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}

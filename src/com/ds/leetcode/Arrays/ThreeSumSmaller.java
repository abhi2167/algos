package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class ThreeSumSmaller {

    public static void main(String[] args) {
        ThreeSumSmaller s = new ThreeSumSmaller();

        // -1 -1 -1 1 -1
        // [3,1,0,-2] 4
        int [] nums = {3,1,0,-2};

        // [-2, 0, 1, 3]   4
        // 3,0,-2     3,1,-2    1,0,-2

        // -2, 0, 1, 3    2
        // -2,0,1   -2, 0, 3   -2,1,3

        int target = 4;
        System.out.println(s.threeSumSmaller(nums, target));
        System.out.println(s.threeSumSmallerBs(nums, target));
    }

    public int threeSumSmallerBs(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for(int i=0; i < nums.length-2; i++) {
            result += twoSumSmallerBs(nums, i, target-nums[i]);
        }
        return result;
    }

    private int twoSumSmallerBs(int []nums, int currentIndex, int target) {
        int result = 0;
        for(int i= currentIndex + 1; i < nums.length-1;i++){
            result+= binarySearchT(nums, i, target-nums[i]) - i;
        }
        return result;
    }

    private int binarySearchT(int[] nums, int start, int target) {
        int end = nums.length-1;
        int result = 0;
        while(start < end) {
            int mid = (start + end + 1)/2;
            if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid-1;
            }
        }
        return start;
    }


    public int threeSumSmaller(int[] nums, int target) {
       int result = 0;
       Arrays.sort(nums);
       for(int i=0; i < nums.length; i++) {
           result += twoSumSmaller(nums, i, target);
       }
        return result;
    }

    private int twoSumSmaller(int[] nums, int currentIndex, int target) {
        int left = currentIndex + 1;
        int right = nums.length - 1;
        int result = 0;
        while(left < right) {
            int sum = nums[currentIndex] + nums[left] + nums[right];
            if(sum < target) {
                result += right - left;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}

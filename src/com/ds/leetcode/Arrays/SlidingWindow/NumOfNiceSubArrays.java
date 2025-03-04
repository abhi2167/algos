package com.ds.leetcode.Arrays.SlidingWindow;

public class NumOfNiceSubArrays {

    public static void main(String[] args) {
        NumOfNiceSubArrays o = new NumOfNiceSubArrays();
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println("number of nice sub arrays containing exactly k odd numbers " + o.numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int totalSubArrays = 0;
        int left = 0;
        int mid = 0;
        int right = 0;
        int numOfOdds = 0;
        while (right < nums.length) {
            numOfOdds += nums[right]%2 == 1 ? 1 : 0;
            while(numOfOdds > k) {
                numOfOdds -= nums[left]%2 == 1 ? 1 : 0;
                left++;
                mid = left;
            }
            if(numOfOdds == k) {
                while(!(nums[mid]%2 == 1)) {
                    mid++;
                }
                totalSubArrays += mid - left + 1;
            }
            right++;
        }
        return totalSubArrays;
    }
}

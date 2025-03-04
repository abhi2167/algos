package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.*;

public class DistinctNumsInEachSubArray {

    public static void main(String[] args) {
        DistinctNumsInEachSubArray d = new DistinctNumsInEachSubArray();
        int[] nums = {1,2,3,2,2,1,3};
        int k = 3;
        System.out.println("Distinct numbers in each sub array = " + Arrays.toString(d.distinctNumbers(nums, k)));
    }

    public int[] distinctNumbers(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int i =0; i < k; i++) {
            numFreq.put(nums[i], numFreq.getOrDefault(nums[i], 0) + 1);
        }
        res[0] = numFreq.size();
        for(int i = k; i < nums.length; i++) {
            numFreq.put(nums[i-k], numFreq.get(nums[i-k]) - 1);
            if(numFreq.get(nums[i-k]) == 0) {
                numFreq.remove(nums[i-k]);
            }
            numFreq.put(nums[i], numFreq.getOrDefault(nums[i], 0) + 1);
            res[i-k+1] = numFreq.size();
        }
        return res;
    }
}

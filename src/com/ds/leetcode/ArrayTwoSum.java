package com.ds.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author abinay.pingili
 * 
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 */
public class ArrayTwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            int matchingNum = target - nums[i];
            if(numsMap.containsKey(matchingNum)) {
                return new int[] {numsMap.get(matchingNum), i};
            } else {
            	numsMap.put(nums[i], i);
            }
        }
        return new int[2];
    }
    
    public static void main(String[] args) {
    	System.out.println("result " + Arrays.toString(twoSum(new int[] {3,1,3},6)));
    }
}

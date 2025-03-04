package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

    public static void main(String[] args) {
        KDiffPairsInArray o = new KDiffPairsInArray();
        int[] nums = {3,1,4,1,5};
        int k = 2;
        System.out.println("Number of unique pairs with K diff between them are = " + o.findPairs(nums, k));
        System.out.println("Number of unique pairs with K diff between them are = " + o.findPairs_hashmap(nums, k));
    }

    public int findPairs_hashmap(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num,0)+1);
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if(numFreq.containsKey(num + k) && k > 0) {
                result++;
            } else if(k == 0 && freq > 1) {
                result++;
            }
        }
        return result;
    }
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int left = 0;
        int right = 0;
        while(left < nums.length && right < nums.length) {
            if(left == right || nums[right] - nums[left] < k) {
                right++;
            } else if(nums[right] - nums[left] > k) {
                left++;
            } else {
                result++;
                left++;
                while(left < nums.length && nums[left] == nums[left-1]) {
                    left++;
                }
            }
        }
        return result;
    }
}

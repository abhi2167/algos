package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDiffIntegers {

    public static void main(String[] args) {
        SubArraysWithKDiffIntegers o = new SubArraysWithKDiffIntegers();
        int [] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(" Num of sub arrays with k diff integers = " + o.subarraysWithKDistinct(nums, k));
        System.out.println(" Num of sub arrays with k diff integers = " + o.subarraysWithKDistinct_using_formula(nums, k));
        System.out.println(" Num of sub arrays with k diff integers using 3 pointers = " + o.subarraysWithKDistinct_using_sliding_3_pointers(nums, k));
    }

    public int subarraysWithKDistinct_using_formula(int[] nums, int k) {
        return subarraysWithKDistinct_atMostK(nums, k) - subarraysWithKDistinct_atMostK(nums, k-1);
    }

    public int subarraysWithKDistinct_atMostK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int totalSubArrays = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        while(right < nums.length) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while(freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left])-1);
                if(freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
            totalSubArrays += right - left + 1;
            right++;
        }
        System.out.println(totalSubArrays);
        return totalSubArrays;
    }

    public int subarraysWithKDistinct_using_sliding_3_pointers(int[] nums, int k) {
        int totalSubArrays = 0;
        int left_far = 0;
        int left_near = 0;
        int right = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        while(right < nums.length) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while(freqMap.size() > k) {
                freqMap.put(nums[left_near], freqMap.get(nums[left_near])-1);
                if(freqMap.get(nums[left_near]) == 0) {
                    freqMap.remove(nums[left_near]);
                }
                left_near++;
                left_far = left_near;
            }
            if(freqMap.size() == k) {
                while(freqMap.get(nums[left_near]) > 1) {
                    freqMap.put(nums[left_near], freqMap.get(nums[left_near])-1);
                    left_near++;
                }
                totalSubArrays += 1 + left_near - left_far;
            }
            right++;
        }
        return totalSubArrays;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // HashMap to store the count of each distinct value in the current window
        HashMap<Integer, Integer> distinctCount = new HashMap<>();

        int totalCount = 0;
        int left = 0;
        int right = 0;
        int currCount = 0;

        while (right < nums.length) {
            // Increment the count of the current element in the window
            distinctCount.put(nums[right], distinctCount.getOrDefault(nums[right], 0) + 1);

            // If encountering a new distinct element, decrement K
            if (distinctCount.get(nums[right]) == 1) {
                k--;
            }
            right++;

            // If K becomes negative, adjust the window from the left
            if (k < 0) {
                // Move the left pointer until the count of distinct elements becomes valid again
                int leftElement = nums[left];
                distinctCount.put(leftElement, distinctCount.get(leftElement) - 1);
                if (distinctCount.get(leftElement) == 0) {
                    distinctCount.remove(leftElement);
                    k++;
                }
                left++;
                currCount = 0;
            }

            // If K becomes zero, calculate subarrays
            if (k == 0) {
                // While the count of the left element remains greater than 1, keep shrinking the window from the left
                while (distinctCount.get(nums[left]) > 1) {
                    int leftElement = nums[left];
                    distinctCount.put(leftElement, distinctCount.get(leftElement) - 1);
                    left++;
                    currCount++;
                }
                // Add the count of subarrays with K distinct elements to the total count
                totalCount += (currCount + 1);
            }
        }
        return totalCount;
    }
}

package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.Arrays;

public class FrequencyOfMostFreqElement {

    public static void main(String[] args) {
        FrequencyOfMostFreqElement o = new FrequencyOfMostFreqElement();
        int[] nums = {1,4,8,13};
        int k = 5;
        System.out.println("FrequencyOfMostFreqElement after k operations " + o.maxFrequency(nums, k));
        System.out.println("FrequencyOfMostFreqElement after k operations " + o.maxFrequency_advanced(nums, k));
    }

    public int maxFrequency_binSearch(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 0;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            maxFreq = Math.max(maxFreq, search(nums, prefix, k, i));
        }
        return maxFreq;
    }

    private int search(int[] nums, long[] prefix, int k, int currentIndex) {

        int left = 0;
        int right = currentIndex;
        int best = currentIndex;
        long target = nums[currentIndex];
        while(left <= right) {
            int mid = (left+right)/2;
            int count = currentIndex - mid + 1;
            long requiredSum = target * count;
            long originalSum = prefix[currentIndex] - prefix[mid] + nums[mid];
            if(requiredSum - originalSum > k) {
                left = mid+1;
            } else {
                best = mid;
                right = mid-1;
            }
        }
        return currentIndex - best + 1;
    }

    public int maxFrequency_advanced(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        long currentSum = 0;
        long target = 0;
        int maxFreq = 0;
        while(right < nums.length) {
            target = nums[right];
            currentSum += target;
            boolean isValid = (right-left+1) * target - currentSum <= k;
            if(!isValid) {
                currentSum -= nums[left];
                left++;
            }
            maxFreq = right - left +  1;
            right++;
        }
        return maxFreq;
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxFreq = 0;
        while(right < nums.length) {
            int target = nums[right];
            currentSum += target;
            while((right-left+1) * target - currentSum > k) {
                currentSum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left +  1);
            right++;
        }
        return maxFreq;
    }
}

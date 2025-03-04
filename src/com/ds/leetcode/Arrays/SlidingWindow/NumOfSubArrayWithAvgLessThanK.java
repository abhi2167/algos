package com.ds.leetcode.Arrays.SlidingWindow;

public class NumOfSubArrayWithAvgLessThanK {

    public static void main(String[] args) {
        NumOfSubArrayWithAvgLessThanK o = new NumOfSubArrayWithAvgLessThanK();
        int arr[] = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;
        System.out.println("NumOfSubArrayWithAvgLessThanK = " + o.numOfSubarrays(arr, k, threshold));
        System.out.println("NumOfSubArrayWithAvgLessThanK 2 = " + o.numOfSubarrays2(arr, k, threshold));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int n = arr.length;
        int currentSum = 0;

        while(right < n) {
            currentSum += arr[right];
            if(right - left + 1 == k) {
                ans += currentSum/k >= threshold ? 1 : 0;
                currentSum -= arr[left];
                left++;
            }
            right++;
        }
        return ans;
    }

    public int numOfSubarrays2(int[] arr, int k, int threshold) {
        int ans = 0;
        int n = arr.length;
        int currentSum = 0;

        for(int i=0; i < k; i++) {
            currentSum += arr[i];
        }
        ans += currentSum/k >= threshold ? 1 : 0;
        for(int i = k; i < n; i++) {
            currentSum += arr[i] - arr[i-k];
            ans += currentSum/k >= threshold ? 1 : 0;

        }
        return ans;
    }
}

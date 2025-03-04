package com.ds.leetcode.Arrays.twopointers;

public class LongestMountainInArray {

    public static void main(String[] args) {
        LongestMountainInArray o = new LongestMountainInArray();
        int[] arr = {2,1,4,7,3,2,5};
        System.out.print("Longest mountain in array = " + o.longestMountain(arr));
    }

    public int longestMountain(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int maxLen = 0;
        while(right < arr.length) {
            // skip the initial valley
            while(right < arr.length && arr[right] <= arr[right-1]) {
                right++;
            }
            left = right-1;
            // find peak of mountain
            while(right < arr.length && arr[right] > arr[right-1]) {
                right++;
            }
            // stop a bottom of the moutain for next cycle to start
            while(right < arr.length && arr[right] < arr[right-1]) {
                maxLen = Math.max(maxLen, right-left+1);
                right++;
            }
        }
        return maxLen;
    }
}

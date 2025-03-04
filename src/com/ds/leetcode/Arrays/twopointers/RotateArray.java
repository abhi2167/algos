package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray o = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        o.rotate1(nums, k);
        System.out.println("Rotated array after k attempts " + Arrays.toString(nums));
        o.rotate1(nums, nums.length-k);
        System.out.println("Original Array " + Arrays.toString(nums));
        o.rotate2(nums, k);
        System.out.println("Rotated array after k attempts " + Arrays.toString(nums));
        o.rotate2(nums, nums.length-k);
        System.out.println("Original Array " + Arrays.toString(nums));
        o.rotate3(nums, k);
        System.out.println("Rotated array after k attempts " + Arrays.toString(nums));
        o.rotate3(nums, nums.length-k);
        System.out.println("Original Array " + Arrays.toString(nums));
    }

    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        for(int i = 0; i < k; i++) {
            int lastEl = nums[n-1];
            for(int j = n-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = lastEl;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverseUsingTwoPointers(nums, 0, n-1);
        reverseUsingTwoPointers(nums,0, k-1);
        reverseUsingTwoPointers(nums, k, n-1);
    }

    private void reverseUsingTwoPointers(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }

    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int count = 0;
        for(int start = 0; count < n; start++) {
            int prev = nums[start];
            int current = start;
            do {
                int next = (current + k)%n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while(start != current);
        }
    }
}

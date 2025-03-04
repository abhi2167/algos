package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;
        r.rotate(nums, k);
        System.out.println("Array rotation result = " + Arrays.toString(nums));

        int nums2[] = {1,2,3,4,5,6,7};
        int k2 = 3;
        r.rotate2(nums2, k2);
        System.out.println("Array rotation result = " + Arrays.toString(nums2));

        int nums3[] = {1,2,3,4,5,6,7};
        int k3 = 3;
        r.rotate3(nums3, k3);
        System.out.println("Array rotation result = " + Arrays.toString(nums3));

        int nums4[] = {1,2,3,4,5,6,7};
        int k4 = 3;
        r.rotate4(nums4, k4);
        System.out.println("Array rotation result = " + Arrays.toString(nums4));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int rotation = k % n;
        for(int i = 0; i < rotation; i++) {
            int lastEl = nums[n-1];
            for(int j = n-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = lastEl;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int rotation = k % n;
        int temp[] = new int[n];
        for(int i = 0; i < n; i++) {
            temp[(i+k)%n] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    public void rotate3(int[] nums, int k) {
       int n = nums.length;
       k = k % n;
       int count = 0;
       for(int start = 0; count < n; start++) {
           int current = start;
           int prev = nums[start];
           do {
               int next = (current + k) % n;
               int temp = nums[next];
               nums[next] = prev;
               prev = temp;
               current = next;
               count++;
           } while(current != start);
       }
    }

    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0 , n-1);
        reverse(nums, 0 , k-1);
        reverse(nums, k , n-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

package com.ds.leetcode.easy;

public class RemoveDuplicateElementFromArray {

    public static void main(String[] args) {
        RemoveDuplicateElementFromArray r = new RemoveDuplicateElementFromArray();
        int []nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println("result using two pointers = " + r.removeElement(nums, val));
        int []nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        System.out.println("result using two pointers = " + r.removeElement_eff(nums2, val2));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while( j < nums.length) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;

    }

    public int removeElement_eff(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while( i < n) {
            if(nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;

    }
}

package com.ds.leetcode.easy;

public class MajorityElementInArray {

    public static void main(String[] args) {
        MajorityElementInArray m = new MajorityElementInArray();
        int [] nums = {7, 7, 5, 7, 5, 1, 5, 7 , 5, 5, 7, 7 ,7, 7, 7, 7};
        System.out.println(" Majority element from array = " + m.majorityElement(nums));
        int [] nums2 = {2,2,1,1,1,2,2};
        System.out.println(" Majority element from array = " + m.majorityElement_dq(nums2));
    }


    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElement_dq(int[] nums) {
        return majorityElement_dq_recur(nums, 0, nums.length-1);
    }

    public int majorityElement_dq_recur(int[] nums, int low, int high) {
        if(low == high) {
            return nums[low];
        }
        int mid = (low+high)/2;
        int left = majorityElement_dq_recur(nums, low, mid);
        int right = majorityElement_dq_recur(nums, mid+1, high);

        if(left == right) {
            return left;
        }
        int leftMajority = countInRange(nums, left, low, high);
        int rightMajority = countInRange(nums, right, low, high);
        return  leftMajority > rightMajority ? left : right;
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++) {
            if(nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

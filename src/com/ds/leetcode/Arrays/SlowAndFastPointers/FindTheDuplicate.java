package com.ds.leetcode.Arrays.SlowAndFastPointers;

public class FindTheDuplicate {

    public static void main(String[] args) {
        FindTheDuplicate o = new FindTheDuplicate();
        int[] nums = {2,6,4,1,3,1,5};
        System.out.println("Duplicate num in array " + o.findDuplicate(nums));
        System.out.println("Duplicate num in array using binay search " + o.findDuplicate_binSearch(nums));
    }

    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);
        tortoise = nums[0];
        while(tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    public int findDuplicate_binSearch(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        int duplicate = 0;
        while(left <= right) {
            mid = (left + right)/2;
            int count = 0;
            for(int num : nums) {
                if(num <= mid) {
                    count++;
                }
            }
            if(count > mid) {
                duplicate = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return duplicate;
    }
}

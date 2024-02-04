package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int nums[] = {-1,-1,-1,-1,-1,-1,1,1};
        int target = 2;
        System.out.println(Arrays.toString(s.twoSum(nums, target)));
        System.out.println(Arrays.toString(s.twoSum_twoPointer_approach(nums, target)));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int x = 0;
        int y = 1;
        while(x < nums.length - 1 && y < nums.length) {
            System.out.println("x " + x + " y " + y);
            int sum = nums[x] + nums[y];
            if(sum == target) {
                result[0] = x+1;
                result[1] = y+1;
                return result;
            } else if (sum < target) {
                if(y == nums.length - 1) {
                    x++;
                    y = x+1;
                } else {
                    y++;
                }
                while(x!=0 && nums[x] == nums[x-1]) {
                    x++;
                    y = x+1;
                }
            } else {
                x++;
                y = x+1;
            }
        }
        return result;
    }

    public int[] twoSum_twoPointer_approach(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            } else if( sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}

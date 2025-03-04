package com.ds.leetcode.Arrays.SlidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArithmeticsSlices {

    public static void main(String[] args) {
        ArithmeticsSlices o = new ArithmeticsSlices();
        int [] nums = {1,3,5,7,9,14};
        System.out.println("Arithmetics slices = " + o.numberOfArithmeticSlices(nums));
        System.out.println("Arithmetics slices = " + o.numberOfArithmeticSlices_dp(nums));
        System.out.println("Arithmetics slices = " + o.numberOfArithmeticSlices_using_formula(nums));
    }

    public int numberOfArithmeticSlices_using_formula(int[] nums) {
        if(nums.length <= 2) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                count++;
            } else {
                sum += (count * (count+1))/2;
                count = 0;
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlices_dp(int[] nums) {
        if(nums.length <= 2) {
            return 0;
        }
        int sum = 0;
        int[] dp = new int[nums.length];
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum;
    }

    public int numberOfArithmeticSlices_btf_2(int[] nums) {
        if(nums.length <= 2) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < nums.length-2; i++) {
            int d = nums[i+1] - nums[i];
            for(int j = i+2; j < nums.length; j++) {
                if(nums[j] - nums[j-1] != d) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length-2; i++) {
            int d = nums[i+1] - nums[i];
            for(int j = i+2; j < nums.length; j++) {
                int k = 0;
                for( k= i+1; k <= j; k++) {
                    if(nums[k] - nums[k-1] != d) {
                        break;
                    }
                }
                if(k > j) {
                    count++;
                }
            }
        }
        return count;
    }
}

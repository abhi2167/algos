package com.ds.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaximumScoreFromMultiplication {
    public static void main(String[] args) {
        MaximumScoreFromMultiplication m = new MaximumScoreFromMultiplication();
        int [] nums = {-5,-3,-3,-2,7,1};
        int [] multipliers = {-10,-5,3,4,6};
        System.out.println("Maximum sum from multipliers " + m.maximumScore(nums, multipliers));
        System.out.println("Maximum sum from multipliers " + m.maximumScore_bu(nums, multipliers));
    }

    public int maximumScore_bu(int[] nums, int[] multipliers) {
        int dp[][] = new int[multipliers.length+1][multipliers.length+1];
        int n = nums.length;
        for(int op = multipliers.length-1; op >=0 ; op--) {
            for(int start = op; start >=0 ; start--) {
                dp[op][start] = Math.max(nums[start] * multipliers[op] + dp[op+1][start+1],
                        nums[n-1-(op-start)] * multipliers[op] + dp[op+1][start]);
            }
        }
        return dp[0][0];
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int dp[][] = new int[nums.length][nums.length];
        int maxScore =  maximumScore(nums, multipliers, 0, nums.length-1, 0, dp);
        for(int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return maxScore;
    }

    public int maximumScore(int[] nums, int[] multipliers, int start, int end , int j, int[][] dp) {

        if (j >= multipliers.length) {
            return 0;
        }
        if(start > end) {
            return 0;
        }
        if(dp[start][end] != 0) {
            return dp[start][end];
        }
        dp[start][end] = Math.max((nums[start] * multipliers[j]) + maximumScore(nums, multipliers, start+1, end, j+1, dp),
                (nums[end] * multipliers[j]) + maximumScore(nums, multipliers, start, end-1, j+1, dp));
        return dp[start][end];
    }


// top down with reduced state
    public int maximumScore(int[] nums, int[] multipliers, int left, int op, int[][] dp) {

        if (op == multipliers.length) {
            return 0;
        }
        int right = (nums.length-1) - (op - left);
        dp[op][left] = Math.max((nums[left] * multipliers[op]) + maximumScore(nums, multipliers, left+1, op+1, dp),
                (nums[right] * multipliers[op]) + maximumScore(nums, multipliers, left, op+1, dp));
        return dp[op][left];
    }
}

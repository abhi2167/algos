package com.ds.leetcode.Arrays.jumpgames;

import java.util.Arrays;

public class CanJump {

    public static void main(String[] args) {
        //int [] nums = {45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,3,2,1,0,0};
        int [] nums = {2,0,1,2,2,0,3};
        CanJump c = new CanJump();
        System.out.println("Can Jump Result ===> "+ c.canJump(nums));
        System.out.println("Can Jump Result canJump_bu ===> "+ c.canJump_bu(nums));
        System.out.println("Can Jump Result canJump_bu_efficient ===> "+ c.canJump_bu_efficient(nums));
    }


    public boolean canJump_bu_efficient(int[] nums) {
        int leftMostGoodIndex = nums.length-1;
        for(int i=nums.length-2; i >=0; i--) {
            int furthestJump = nums[i]+i;
            if(furthestJump >= leftMostGoodIndex) {
                leftMostGoodIndex = i;
            }
        }
        return leftMostGoodIndex == 0;
    }

    public boolean canJump_bu(int[] nums) {
        boolean [] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        int leftMostGoodIndex = nums.length-1;
        for(int i=nums.length-2; i >=0; i--) {
            int furthestJump = Math.min(nums[i]+i, nums.length-1);
            for(int nextPos = i+1; nextPos <= furthestJump; nextPos++) {
                if(dp[nextPos]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public boolean canJump(int[] nums) {
        boolean [] dp = new boolean[nums.length];
        return canJump_tp(nums, 0, dp);
    }

    public boolean canJump_tp(int[] nums, int currentIndex, boolean []dp) {
        if(currentIndex == nums.length-1 || nums.length == 1) {
            return true;
        }
        if(currentIndex >= nums.length || nums[currentIndex] == 0) {
            return false;
        }
        if(!dp[currentIndex]) {
            int currentValue = nums[currentIndex];
            int furthestJump = Math.min(currentIndex + currentValue, nums.length-1);
            for(int nextPosition = currentIndex+1; nextPosition <= furthestJump; nextPosition++) {
                if(canJump_tp(nums, nextPosition, dp)) {
                   dp[currentIndex] = true;
                    System.out.println(Arrays.toString(dp));
                    return true;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return false;
    }

}

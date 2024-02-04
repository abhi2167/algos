package com.ds.leetcode.Arrays.jumpgames;

public class CanJumpMinimumJumps {

    public static void main(String[] args) {
        //int [] nums = {45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,3,2,1,0,0};
        int [] nums = {1,2,1,1,4};
        //int [] nums = {1,1,4};
        /*
        1 - 1
        1- 1,1
        3 - 3 or 2,1 or 1,1,1
        2 - 1,3 or 2,1,1 or 2,1,1,1
         */
        CanJumpMinimumJumps c = new CanJumpMinimumJumps();
        System.out.println("Minimum Jumps Result ===> "+ c.minimumJumps(nums));
    }

    private int minimumJumps(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int maxFurthestEnd = 0;
        int currentEnd = 0;
        for(int i=0; i < n-1; i++) {
            maxFurthestEnd = Math.max(nums[i]+i, maxFurthestEnd);
            if (currentEnd == i) {
                jumps++;
                currentEnd = maxFurthestEnd;
            }
        }
        return jumps;
    }
}
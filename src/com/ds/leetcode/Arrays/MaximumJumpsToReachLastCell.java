package com.ds.leetcode.Arrays;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumJumpsToReachLastCell {

    public static void main(String[] args) {
        MaximumJumpsToReachLastCell o = new MaximumJumpsToReachLastCell();
//        int [] nums = {1,0,2};
//        int target = 1;
        int [] nums = {1,3,6,4,1,2};
        int target = 2;
//        int [] nums = {1,3,6,4,1,2};
//        int target = 3;
        System.out.println(" Max jumps " + o.maximumJumps(nums, target));
        //System.out.println(" Max jumps " + o.maximumJumps_tp(nums, target));
    }

    public int maximumJumps(int[] nums, int target) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int maxJumps = 0;
        int n = nums.length;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int pos = queue.poll();
                if(pos == n - 1) {
                    return maxJumps;
                }
                int j = pos + 1;
                while(j < n ) {
                    if(Math.abs(nums[j] - nums[pos]) <= target) {
                        queue.add(j);
                    }
                    j++;
                }
            }
            maxJumps++;
            System.out.println(" max jumps " + maxJumps + " queue " + queue.peek());
        }
        return -1;
    }

    public int maximumJumps_tp(int[] nums, int target) {
        int [] dp = new int[nums.length];
        return maximumJumps_tp(nums, target, 0, dp);
    }

    private int maximumJumps_tp(int[] nums, int target, int i, int dp[]) {
        if(i == nums.length - 1) {
            return 0;
        }
        if(dp[i] != 0) {
            return dp[i];
        }
        int jumps = -1;
        for(int j = i + 1; j < nums.length; j++) {
            if(Math.abs(nums[i] - nums[j]) <= target) {
                int ans = maximumJumps_tp(nums, target, j, dp);
                if (ans >= 0) {
                    ans += 1;
                }
                jumps = Math.max(jumps, ans);

            }
            dp[i] = jumps;
        }
        return dp[i];
    }
}

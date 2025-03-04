package com.ds.leetcode.Arrays.SlowAndFastPointers;

public class CircularSubArray {

    public static void main(String[] args) {
        CircularSubArray o = new CircularSubArray();
        int [] nums = {1,-1,5,1,4};
        System.out.println("Does sub array with cycle exist  ? = " + o.circularArrayLoop(nums));
    }

    public boolean circularArrayLoop(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                int slow = i;
                int fast = i;
                boolean forward = nums[i] >= 0;
                while(true) {
                    slow = findNextIndex(nums, forward, slow);
                    if(slow == -1) {
                        break;
                    }
                    fast = findNextIndex(nums, forward, fast);
                    if(fast == -1) {
                        break;
                    }
                    fast = findNextIndex(nums, forward, fast);
                    if(fast == -1) {
                        break;
                    }
                    if(slow == fast) {
                        return true;
                    }
                    visited[slow] = true;
                    visited[fast] = true;
                }
            }
        }
        return false;
    }

    private int findNextIndex(int[] nums, boolean forward, int current) {
        boolean direction = nums[current] >= 0;
        if(direction != forward) {
            return -1;
        }
        int nextIndex = (current + nums[current])%nums.length;
        if(nextIndex < 0) {
            nextIndex += nums.length;
        }
        if(current == nextIndex) {
            return -1;
        }
        return nextIndex;
    }
}

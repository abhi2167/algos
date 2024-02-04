package com.ds.leetcode.Arrays.jumpgames;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CanJumpReachZero {
    static int beginIndex;
    public static void main(String[] args) {
        int [] nums = {4,2,3,0,3,1,2};
        int start = 5;
        CanJumpReachZero c = new CanJumpReachZero();
        beginIndex = start;
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        HashSet<Integer> visited = new HashSet<>();
        System.out.println("Can Reach Result ===> "+ c.canReach(nums, start, visited));
        System.out.println("Can Reach Result ===> "+ c.canReach_bfs(nums, start));
    }

    private boolean canReach(int[] nums, int currentIndex, HashSet<Integer> visited) {

        if(currentIndex >= nums.length || currentIndex < 0) {
            visited.add(currentIndex);
            return false;
        }
        if(nums[currentIndex] == 0) {
            visited.add(currentIndex);
            return true;
        }
        if(!visited.contains(currentIndex)) {
            visited.add(currentIndex);
            return  canReach(nums, currentIndex + nums[currentIndex], visited)
                    ||  canReach(nums, currentIndex - nums[currentIndex], visited);
        }
        return false;
    }

    //BFS Approach

    private boolean canReach_bfs(int[] nums, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int currentIndex = queue.poll();
            if(nums[currentIndex] == 0) {
                return  true;
            }
            if(nums[currentIndex] < 0) {
                continue;
            }

            if (currentIndex + nums[currentIndex] < nums.length) {
                queue.add(currentIndex+nums[currentIndex]);
            }
            if(currentIndex - nums[currentIndex] >= 0) {
                queue.add(currentIndex -  nums[currentIndex]);
            }
            nums[currentIndex] = - nums[currentIndex];
        }
        return  false;
    }

}

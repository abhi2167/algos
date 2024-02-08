package com.ds.leetcode.Arrays.jumpgames;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class JumpGameVI {

    public static void main(String[] args) {
        JumpGameVI j = new JumpGameVI();
        //int [] nums = {10,-5,-2,4,0,3};
        //int k = 3;
        int [] nums = {1,-5,-20,4,-1,3,-6,-3};
        int k = 2;
        System.out.println("Maximum score " + j.maxResult(nums, k));
        System.out.println("Maximum score " + j.maxResult2(nums, k));
        System.out.println("Maximum score " + j.maxResult_tp(nums, k));
    }

    public int maxResult_tp(int[] nums, int k) {
        int dp[] = new int[nums.length];
        for(int i=0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        return maxResult_tp(nums, k , 0, dp);
    }

    public int maxResult_tp(int[] nums, int k, int currentIndex, int[] dp) {
        if(currentIndex >= nums.length-1) {
            return nums[nums.length-1];
        }
        if(dp[currentIndex] != Integer.MIN_VALUE) {
            return dp[currentIndex];
        }

        int score = Integer.MIN_VALUE;
        int furthestJump = Math.min(nums.length-1, currentIndex + k);
        for(int j = currentIndex + 1; j <= furthestJump; j++) {
            score = Math.max(score, nums[currentIndex] + maxResult_tp(nums, k, j, dp));
            System.out.println(" current index " + currentIndex + " score " + score);
        }
        dp[currentIndex] = score;
        return dp[currentIndex];
    }


    public int maxResult2(int[] nums, int k) {
        int []score = new int[nums.length];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.add(0);
        for(int i=1; i < nums.length; i++) {
            while(dq.peekFirst() != null && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            score[i] = nums[i] + score[dq.peek()];
            while(dq.peekLast() != null && score[i] >= dq.peekLast()) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[score.length-1];
    }

    public int maxResult(int[] nums, int k) {
        int []score = new int[nums.length];
        score[0] = nums[0];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        queue.add(new int[]{nums[0], 0});
        for(int i=1; i < nums.length; i++) {
            while(queue.peek()[1] < i - k) {
                queue.remove();
            }
            score[i] = nums[i] + queue.peek()[0];
            queue.add(new int[]{score[i], i});
        }
        return score[score.length-1];
    }
}

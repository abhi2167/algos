package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        System.out.println(" max sliding window " + Arrays.toString(s.maxSlidingWindow_bf(nums, k)));
        System.out.println(" max sliding window " + Arrays.toString(s.maxSlidingWindow_tp(nums, k)));
        System.out.println(" max sliding window " + Arrays.toString(s.maxSlidingWindow_dq(nums, k)));

    }

    private int[] maxSlidingWindow_dq(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);
        int i = k;
        while (i < nums.length) {
            while(dq.peekFirst() != null && dq.peekFirst() <= i - k ) {
                dq.pollFirst();
            }
            while(dq.peekLast()!= null && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            System.out.println(" index i " + i + " peek " + nums[dq.peekFirst()] + " peek last " + nums[dq.peekLast()]);
            res.add(nums[dq.peekFirst()]);
            i++;
        }
        return res.stream().mapToInt(j -> j).toArray();
    }

    public int[] maxSlidingWindow_tp(int[] nums, int k) {
        int [] maxWindow = new int[nums.length-k+1];
        return maxSlidingWindow_tp(nums, k, maxWindow, 0, k-1, 0);
    }

    private int[] maxSlidingWindow_tp(int[] nums, int k, int[] maxWindow, int start, int end, int currentIndex) {
        int maxNum = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }
        maxWindow[currentIndex] = maxNum;
        if(end == nums.length-1) {
            return maxWindow;
        } else {
            maxSlidingWindow_tp(nums, k, maxWindow, start+1, end+1, currentIndex+1);
            return maxWindow;
        }
    }

    public int[] maxSlidingWindow_bf(int[] nums, int k) {
        int start = 0;
        int end = k-1;
        int [] maxWindow = new int[nums.length-k+1];
        int maxIndex = 0;
        while(end <= nums.length-1) {
            int maxNum = Integer.MIN_VALUE;
            for(int i = start; i <= end; i++) {
                maxNum = Math.max(maxNum, nums[i]);
            }
            maxWindow[maxIndex] = maxNum;
            maxIndex++;
            start++;
            end++;
        }
        return maxWindow;
    }
}

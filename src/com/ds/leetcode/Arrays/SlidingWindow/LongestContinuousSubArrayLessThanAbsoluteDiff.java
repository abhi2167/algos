package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.*;

public class LongestContinuousSubArrayLessThanAbsoluteDiff {
    public static void main(String[] args) {
        LongestContinuousSubArrayLessThanAbsoluteDiff o = new LongestContinuousSubArrayLessThanAbsoluteDiff();
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        System.out.println("Longest subarray with absolute diff less than or equal to k " + o.longestSubarray(nums, limit));
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < nums.length) {
            minHeap.offer(new int[]{nums[right], right});
            maxHeap.offer(new int[]{nums[right], right});
            while(maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;
                while(maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }
                while(minHeap.peek()[1] < left) {
                    minHeap.poll();
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }


    public int longestSubarray_deque(int[] nums, int limit) {
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < nums.length) {
            int currentNum = nums[right];
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < currentNum) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(currentNum);
            while(!minQueue.isEmpty() && minQueue.peekLast() > currentNum) {
                minQueue.pollLast();
            }
            minQueue.offerLast(currentNum);

            while(maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if(minQueue.peekFirst() == nums[left]) {
                    minQueue.pollFirst();
                }
                if(maxQueue.peekFirst() == nums[left]) {
                    maxQueue.pollFirst();
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public int longestSubarray_usingTreeMap(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        TreeMap<Integer, Integer> minMaxSet = new TreeMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < nums.length) {
            minMaxSet.put(nums[right], right);
            while(minMaxSet.lastKey() - minMaxSet.firstKey() > limit) {
                minMaxSet.put(nums[left], minMaxSet.get(nums[left]) - 1);
                if(minMaxSet.get(nums[left]) == 0) {
                    minMaxSet.remove(nums[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}

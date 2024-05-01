package com.ds.course.monotonic.stack;

import java.util.*;

public class MonotonicStack {

    public static void main(String[] args) {
        MonotonicStack m = new MonotonicStack();
        int [] nums = {1,5,3,4,0};
        System.out.println("longest increasing subsequence = " + Arrays.toString(m.longestIncreasingSubSequence(nums)));
        System.out.println("longest decreasing subsequence = " + Arrays.toString(m.longestDecreasingSubSequence(nums)));

        System.out.println("Original sequence = " + Arrays.toString(nums));
        System.out.println("next greater sequence = " + Arrays.toString(m.nextGreaterSequence(nums)));
        System.out.println("previous greater sequence = " + Arrays.toString(m.previousGreaterSequence(nums)));
        System.out.println("next smaller sequence = " + Arrays.toString(m.nextSmallerSequence(nums)));
        System.out.println("next greater sequence circular= " + Arrays.toString(m.nextGreaterSequenceCircular(nums)));

    }

    public int[] nextGreaterSequenceCircular(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);
        for(int j= 0; j < 2; j++) {
            for(int i = 0; i < nums.length; i++) {
                while(stack.peekLast() != null && nums[stack.peekLast()] < nums[i]) {
                    nextGreater[stack.pollLast()] = i;
                }
                stack.offerLast(i);
            }

        }
        return Arrays.stream(nextGreater).map(i -> i == -1 ? -1: nums[i]).toArray();
    }

    public int[] nextGreaterSequence(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);
        for(int i = 0; i < nums.length; i++) {
            while(stack.peekLast() != null && nums[stack.peekLast()] < nums[i]) {
                nextGreater[stack.pollLast()] = i;
            }
            stack.offerLast(i);
        }

        return Arrays.stream(nextGreater).map(i -> i == -1 ? -1: nums[i]).toArray();
    }

    public int[] previousGreaterSequence(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] prevGreater = new int[nums.length];
        Arrays.fill(prevGreater, -1);
        for(int i = 0; i < nums.length; i++) {
            while(stack.peekLast() != null && nums[stack.peekLast()] <= nums[i]) {
                stack.pollLast();
            }
            prevGreater[i] = stack.peekLast() == null ? -1 : stack.peekLast();
            stack.offerLast(i);
        }

        return Arrays.stream(prevGreater).map(i -> i == -1 ? -1: nums[i]).toArray();
    }

    public int[] nextSmallerSequence(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nextSmaller = new int[nums.length];
        Arrays.fill(nextSmaller, -1);
        for(int i = 0; i < nums.length; i++) {
            while(stack.peekLast() != null && nums[stack.peekLast()] > nums[i]) {
                nextSmaller[stack.pollLast()] = i;
            }
            stack.offerLast(i);
        }

        return Arrays.stream(nextSmaller).map(i -> i == -1 ? -1: nums[i]).toArray();
    }

    public int[] longestIncreasingSubSequence(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            while(stack.peekLast() != null && stack.peekLast() > nums[i]) {
                stack.pollLast();
            }
            stack.offerLast(nums[i]);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public int[] longestDecreasingSubSequence(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            while(stack.peekLast() != null && stack.peekLast() < nums[i]) {
                stack.pollLast();
            }
            stack.offerLast(nums[i]);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}

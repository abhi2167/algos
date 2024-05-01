package com.ds.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement2 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 8, 6, 4, 5};
        NextGreaterElement2 n = new NextGreaterElement2();
        System.out.println("next greater element = " + Arrays.toString(n.nextGreaterElements(nums)));
        System.out.println("next greater element brute force = " + Arrays.toString(n.nextGreaterElements_btf(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                while (stack.peekLast() != null && nums[stack.peekLast()] < nums[i]) {
                    nextGreater[stack.pollLast()] = i;
                }
                stack.offerLast(i);
            }

        }
        return Arrays.stream(nextGreater).map(i -> i == -1 ? -1 : nums[i]).toArray();
    }

    public int[] nextGreaterElements_btf(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);
        int n = nums.length;
        for(int i=0; i < n; i++) {
            nextGreater[i] = -1;
            for(int j = 1; j < n; j++) {
                if(nums[(i+j)%n] > nums[i]) {
                    nextGreater[i] = nums[(i+j)%n];
                    break;
                }
            }
        }
        return nextGreater;
    }
}

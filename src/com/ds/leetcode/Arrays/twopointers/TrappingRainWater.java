package com.ds.leetcode.Arrays.twopointers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater o = new TrappingRainWater();
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(height));
        System.out.println("total rain water that can be trapped = " + o.trap_btf(height));
        System.out.println("total rain water that can be trapped  = " + o.trap_dp(height));
        System.out.println("total rain water that can be trapped  = " + o.trap_stack(height));
        System.out.println("total rain water that can be trapped  = " + o.trap_stack_using_two_pointers(height));
    }

    public int trap_stack_using_two_pointers(int[] height) {
        int totalWater = 0;

        int n = height.length;
        int left_max = 0;
        int right_max = 0;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            if(height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                totalWater += left_max - height[left];
                left++;
            } else {
                right_max = Math.max(right_max, height[right]);
                totalWater += right_max - height[right];
                right--;
            }
        }
        return totalWater;
    }
    public int trap_stack(int[] height) {
        int totalWater = 0;

        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(stack.peekLast() != null && height[stack.peekLast()] <= height[i]) {
                int currentIndex = stack.pollLast();
                int left_max = stack.peekLast() != null ? stack.peekLast() : 0;
                int right_max = i;
                int boundedHeight = Math.min(height[left_max], height[right_max]) - height[currentIndex];
                int width = right_max - left_max - 1;
                totalWater += (width * boundedHeight);
            }
            stack.offerLast(i);
        }

        return totalWater;
    }

    public int trap_dp(int[] height) {
        int totalWater = 0;

        int n = height.length;
        int[] left_max = new int[n];
        left_max[0] = height[0];
        for(int i = 1; i < n -1; i++) {
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        int[] right_max = new int[n];
        right_max[n -1] = height[n -1];
        for(int i = n -2; i>=0; i--) {
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }
        System.out.println(Arrays.toString(left_max));
        for(int i = 1; i < height.length-1; i++) {
            totalWater += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return totalWater;
    }

    public int trap_btf(int[] height) {
        int totalWater = 0;
        int left_max = height[0];
        int right_max = 0;
        for(int i = 1; i < height.length-1; i++) {
            left_max = Math.max(left_max, height[i]);
            right_max = 0;
            for(int j = i; j < height.length; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            totalWater += Math.min(left_max, right_max) - height[i];
        }
        return totalWater;
    }
}

package com.ds.leetcode.hard.dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater r = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Max water that can be trapped brute force = " + r.trap_btf(height));
        System.out.println("Max water that can be trapped brute force 2 = " + r.trap_btf2(height));
        System.out.println("Max water that can be trapped dp = " + r.trap_dp(height));
        System.out.println("Max water that can be trapped two pointers = " + r.trap_two_pointers(height));
        System.out.println("Max water that can be trapped stack = " + r.trap_stack(height));
    }

    public int trap_btf(int[] height) {
        int left_max = height[0];
        int right_max = 0;
        int trap = 0;
        for(int i = 1; i < height.length-1; i++) {
            left_max = Math.max(left_max, height[i]);
            right_max = 0;
            for(int j = i; j < height.length; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            trap += Math.min(left_max, right_max) - height[i];
        }
        return trap;
    }

    public int trap_btf2(int[] height) {
        int trap = 0;
        for(int i = 1; i < height.length-1; i++) {
            int left_max = 0;
            int right_max = 0;
            for(int j = i; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            for(int j = i; j < height.length; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            trap += Math.min(left_max, right_max) - height[i];
        }
        return trap;
    }

    public int trap_dp(int[] height) {
        int trap = 0;
        int[] left_max = new int[height.length];
        int[] right_max =  new int[height.length];
        left_max[0] = height[0];
        for(int i=1; i < height.length-1; i++) {
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        right_max[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i > 0; i--) {
            right_max[i] = Math.max(height[i],  right_max[i+1]);
        }
        for(int i = 1; i < height.length-1; i++) {
            trap += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return trap;
    }

    public int trap_two_pointers(int[] height) {
        int trap = 0;
        int left = 0;
        int right = height.length-1;
        int left_max = 0;
        int right_max = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                trap += left_max - height[left];
                left++;
            } else {
                right_max = Math.max(right_max, height[right]);
                trap += right_max - height[right];
                right--;
            }
        }
        return trap;
    }

    public int trap_stack(int[] height) {
        int trap = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < height.length; i++) {
            while(stack.peekLast() != null && height[stack.peekLast()] <= height[i]) {
                int currentIndex = stack.pollLast();
                int left_max = stack.peekLast() != null ? height[stack.peekLast()] : 0;
                int right_max = height[i];
                int h = Math.min(left_max, right_max) - height[currentIndex];
                int w = i - left_max - 1;
                trap += (h*w);
            }
            stack.offerLast(i);
        }
        return trap;
    }
}

package com.ds.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Find132Pattern {

    public static void main(String[] args) {
        Find132Pattern f = new Find132Pattern();
        int [] nums = {-2,1,2,-2,1,2};
        System.out.println("132 pattern result = " + f.find132pattern4(nums));
    }

    public boolean find132pattern4(int[] nums) {
        if(nums.length == 0) {
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] minimum = new int[nums.length];
        stack.offerLast(0);
        minimum[0] = 0;
        for(int i=1; i < nums.length; i++) {
            if(nums[i] < nums[minimum[i-1]]) {
                minimum[i] = i;
            } else {
                minimum[i] = minimum[i-1];
            }
            while(stack.peekLast() != null && nums[stack.peekLast()] <= nums[i]) {
                stack.pollLast();
            }
            if(stack.peekLast() != null)
                System.out.println("nums[i] " + nums[i] + " stack top " + nums[stack.peekLast()] + " k = " + nums[minimum[stack.peekLast()]]);
            if(stack.peekLast() != null && nums[i] > nums[minimum[stack.peekLast()]] ) {
                return true;
            }
            stack.offerLast(i);
        }
        return false;
    }

    public boolean find132pattern3(int[] nums) {
        int[] minimum = new int[nums.length];
        minimum[0] = 0;
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] < nums[minimum[i-1]]) {
                minimum[i] = i;
            } else {
                minimum[i] = i-1;
            }
            for(int j=i+1; j < nums.length; j++) {
                if(nums[i] > nums[j] && nums[j] > nums[minimum[i]]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find132pattern(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    for(int k=j+1; k < nums.length; k++) {
                        if(nums[k] < nums[j] && nums[k] > nums[i]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean find132pattern_2(int[] nums) {
        int min_i = Integer.MAX_VALUE;
            for(int j=0; j < nums.length-1; j++) {
                min_i = Math.min(min_i, nums[j]);
                    for(int k=j+1; k < nums.length; k++) {
                        if(nums[k] < nums[j] && nums[k] > min_i) {
                            return true;
                        }
                    }
            }
        return false;
    }

    public boolean find132pattern_stack(int[] nums) {
        int min_i = Integer.MAX_VALUE;
        for(int j=0; j < nums.length-1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for(int k=j+1; k < nums.length; k++) {
                if(nums[k] < nums[j] && nums[k] > min_i) {
                    return true;
                }
            }
        }
        return false;
    }
}

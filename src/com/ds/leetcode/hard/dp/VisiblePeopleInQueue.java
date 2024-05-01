package com.ds.leetcode.hard.dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class VisiblePeopleInQueue {

    public static void main(String[] args) {
        VisiblePeopleInQueue v = new VisiblePeopleInQueue();
        int[] heights = {10,6,8,5,11,9};
        System.out.println("Visible people in queue = " + v.canSeePersonsCount(heights));

    }

    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            while(stack.peekLast() != null && heights[stack.peekLast()] <= heights[i]) {
                result[stack.pollLast()] += 1;
            }
            if(stack.peekLast() != null) {
                result[stack.peekLast()] += 1;
            }
            stack.offerLast(i);
        }
        return result;
    }
}

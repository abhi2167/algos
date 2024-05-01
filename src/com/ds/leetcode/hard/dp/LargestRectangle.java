package com.ds.leetcode.hard.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangle {

    public static void main(String[] args) {
        LargestRectangle l = new LargestRectangle();
        int[] heights = {2,1,5,6,2,3};
        System.out.println("Largest rectangle area btf = " + l.largestRectangleArea_btf(heights));
        System.out.println("Largest rectangle area btf 2 = " + l.largestRectangleArea_btf2(heights));
        System.out.println("Largest rectangle area stack = " + l.largestRectangleArea_stack(heights));
        System.out.println("Largest rectangle area divide and conquer = " + l.largestRectangleArea_tp(heights));
        System.out.println("Largest rectangle area mono stack effective = " + l.largestRectangleArea_mono_stack(heights));
    }

    public int largestRectangleArea_mono_stack(int[] heights) {
        int maxArea = 0;
        int[] nextSmaller = new int[heights.length];
        int[] prevSmaller = new int[heights.length];
        Arrays.fill(nextSmaller, heights.length);
        Arrays.fill(prevSmaller, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++) {
            while(stack.peekLast() != null && heights[stack.peekLast()] > heights[i]) {
                nextSmaller[stack.pollLast()] = i;
            }
            if(stack.peekLast() != null) {
                prevSmaller[i] = stack.peekLast();
            }
            stack.offerLast(i);
        }
        for(int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            int rightSideEdgeOfRectangle = nextSmaller[i];
            int leftSideEdgeOfRectangle = prevSmaller[i];
            int w = rightSideEdgeOfRectangle - leftSideEdgeOfRectangle - 1;
            maxArea = Math.max(maxArea, currentHeight * w);
        }
        return maxArea;
    }

    public int largestRectangleArea_btf(int[] heights) {
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            for(int j = i; j >=0; j--) {
                int currentMinHeight = Integer.MAX_VALUE;
                for(int k = j; k <= i; k++) {
                    currentMinHeight = Math.min(currentMinHeight, heights[k]);
                }
                int w = i-j+1;
                maxArea = Math.max(maxArea, currentMinHeight * w);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea_btf2(int[] heights) {
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int currentMinHeight = Integer.MAX_VALUE;
            for(int j = i; j < heights.length; j++) {
                currentMinHeight = Math.min(currentMinHeight, heights[j]);
                int w = j-i+1;
                maxArea = Math.max(maxArea, currentMinHeight * w);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea_tp(int[] heights) {
        return largestRectangleArea_dq(heights, 0, heights.length-1);
    }

    public int largestRectangleArea_dq(int[] heights, int start, int end) {
        if(start > end) {
            return 0;
        }
        int minHeight = start;
        for(int i=start; i <= end; i++) {
            if(heights[minHeight] > heights[i]) {
                minHeight = i;
            }
        }
        int a1 = heights[minHeight] * (end - start + 1);
        int a2 = largestRectangleArea_dq(heights, start, minHeight-1);
        int a3 = largestRectangleArea_dq(heights, minHeight+1, end);
        return Math.max(a1, Math.max(a2, a3));
    }

    public int largestRectangleArea_stack(int[] heights) {
        int maxArea = 0;
        int[] nextSmaller = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i < heights.length; i++) {
            while(stack.peekLast() != null && heights[stack.peekLast()] > heights[i]) {
                nextSmaller[stack.pollLast()] = i;
            }
            stack.offerLast(i);
        }
        for(int i = 0; i < heights.length; i++) {
            int currentMinHeight = Integer.MAX_VALUE;
            for(int j = i; j >=0; j--) {
                int nextSmallerIndex = nextSmaller[j] == 0 ? j : nextSmaller[j];
                if( nextSmallerIndex > i) {
                    currentMinHeight = Math.min(currentMinHeight, Math.min(heights[i], heights[j]));
                } else {
                    currentMinHeight = Math.min(currentMinHeight, nextSmaller[j] == 0 ? heights[j] : heights[nextSmaller[j]]);
                }

                int w = i-j+1;
                maxArea = Math.max(maxArea, currentMinHeight * w);
            }
        }
        return maxArea;
    }
}

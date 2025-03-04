package com.ds.leetcode;

/***
	You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class MaxContainerArea {
	
	public static void main(String[] args) {
		int []height = {1,8,6,2,5,4,8,3,7};
		MaxContainerArea a = new MaxContainerArea();
		System.out.println("Result :: "+ a.maxArea1(height));
		System.out.println("Result :: "+ a.maxArea2(height));
		System.out.println("Result topdown :: "+ a.maxArea_tp(height));
	}

    public int maxArea1(int[] height) {
        int maxArea = 0;
        for(int i=0; i < height.length; i++) {
        	for(int j=i+1; j < height.length; j++) {
        		int area = Math.min(height[i], height[j]) * (j-i);
        		maxArea = Math.max(area, maxArea);
        	}
        }
        return maxArea;
    }
    
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0,right = height.length - 1;
        int containerArea = 0;
        while(left < right) {
        	containerArea = Math.min(height[left], height[right]) * (right - left);
        	maxArea = Math.max(maxArea, containerArea);
        	if(height[left] < height[right]) {
        		left++;
        	} else if(height[left] > height[right]) {
        		right--;
        	} else {
        		left++;
        		right--;
        	}
        }
        return maxArea;
    }

	public int maxArea_tp(int[] height) {
		int dp[][] = new int[height.length][height.length];
		return maxArea_tp(height, 0, height.length-1, dp);
	}

	public int maxArea_tp(int[] height, int left, int right, int[][] dp) {
		if(left >= right) {
			return 0;
		}
		int a1 = Math.min(height[left], height[right]) * (right - left);
		return dp[left][right] = Math.max(a1, Math.max(maxArea_tp(height, left+1, right, dp), maxArea_tp(height, left, right-1, dp)));
	}
}

package com.ds.leetcode.medium;

import java.util.Arrays;

/**
 * 
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 *
 */
public class FirstAndLastIndexOfElementInArray {
	
	
	public static void main(String[] args) {
		FirstAndLastIndexOfElementInArray fl = new FirstAndLastIndexOfElementInArray();
		int []nums = {2,2};
		int target = 2;
		int []result = {-1,-1};
		System.out.println("Result 0(N) is :: " + Arrays.toString(fl.searchRange(nums, target)));
		System.out.println("Result 0(log N) is :: " + Arrays.toString(fl.searchRange_logN(nums, target)));
		System.out.println("Result 0(log N) is :: " + Arrays.toString(fl.searchRange_loop(nums, target)));
	}
	
	 public int[] searchRange(int[] nums, int target) {
		 int []result = {-1,-1};
		 int i=0;
		 while(i < nums.length) {
			 if(nums[i] == target) {
				 if(result[0] == -1) {
					 result[0] = i;
				 } else {
					 result[1] = i;
				 }
			 }
			 i++;
		 }
		 if(result[1] == -1)
			 result[1] = result[0];
		 return result;
	 }
	 
	 public int[] searchRange_logN(int[] nums, int target) {
		 int []result = {-1,-1};
		 boolean lower = true;
		 int firstIndex = searchRangeBinary(nums, target,0, nums.length-1, lower);
		 int secondIndex = searchRangeBinary(nums, target,0, nums.length-1, false);
		 System.out.println("firstIndex "  + firstIndex + " second index "+ secondIndex);
		 result[0] = firstIndex;
		 result[1] = secondIndex;
		 return result;
	 }
	 
	 public int[] searchRange_loop(int[] nums, int target) {
		 int firstIndex = searchRangeBinary_loop(nums, target,true);
		 if(firstIndex == -1)
			 return new int[] {-1,-1};
		 int secondIndex = searchRangeBinary_loop(nums, target, false);
		 System.out.println(" firstIndex "  + firstIndex + " second index "+ secondIndex);
		 return new int[] {firstIndex, secondIndex};
	 }

	 public int searchRangeBinary(int[] nums, int target, int start, int end, boolean lower) {
		 if(start <= end) {
			 int mid = (start + end)/2;
			 if(nums[mid] == target) {
				 if (lower && mid-1 >=0 && nums[mid-1] == nums[mid]) {
					 return searchRangeBinary(nums, target, start, mid-1, lower);
				 } else if(!lower && mid+1 < nums.length && nums[mid+1] == nums[mid]) {
					 return searchRangeBinary(nums, target, mid+1, end, lower);
				 } else {
					 return mid;
				 }
				 
			 } else if(target < nums[mid]) {
				 return searchRangeBinary(nums, target, start, mid-1, lower);
			 } else {
				 return searchRangeBinary(nums, target, mid+1, end, lower);
			 }
		 } else {
			 return -1;
		 }
	 }
	 
	 public int searchRangeBinary_loop(int []nums, int target, boolean lower) {
		 int start = 0;
		 int end = nums.length - 1;
		 while(start <= end) {
			 int mid = (start + end)/2;
			 if(nums[mid] == target) {
				 if(lower) {
					 if(mid == start || nums[mid] != nums[mid-1]) {
						 return mid;
					 }
					 end = mid - 1;
				 } else {
					 if(mid == end || nums[mid] != nums[mid+1]) {
						 return mid;
					 }
					 start = mid + 1;
				 }
			 } else if(nums[mid] > target) {
				 end = mid-1;
			 } else {
				 start = mid+1;
			 }
		 }
		 return -1;
	 }
}

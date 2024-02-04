package com.ds.ds;

/**
 * 
 * @author abinay.pingili
 * 
Given that we have a sorted array of integers which is rotated n times (n >= 0).

Write a program to find the index of a target number in an array with O(log n) complexity.

if the target number doesn't exist, then return -1.
 

Example 1:
Input: nums = [8,10,12,14,2,4,6], target = 2
Output: 4

Example 2:
Input: nums = [7,9,11,13,1,3,5], target = 4
Output: -1

Example 3:
Input: nums = [4,5,6,7,0,1,2], target = 5
Output: 1
 *
 */
public class SearchInRotatedSortedArray {

	 public static int search(int[] nums, int target) {
	        int start = 0;
	        int end = nums.length - 1;
	        int mid = 0;
	        int targetIndex = -1;
	        while(start <= end) {
	        	System.out.println(start + " " + end);
	        	mid = (start+end)/2;
	            if(nums[mid] == target) {
	                targetIndex = mid;
	            }
	            if(nums[start] <= nums[mid]) {
	            	if(target >= nums[start] && target < nums[mid]) {
	            		end = mid - 1;
	            	} else {
	            		start = mid + 1;
	            	}
	            }
	            if(nums[mid] <= nums[end]) {
	            	if(target > nums[mid] && target <= nums[end])
	            		start = mid + 1;
	            	else
	            		end = mid - 1;
	            }
	            
	        }
	        return targetIndex;
	    }
	 
	 public static void main(String[] args) {
		 int[] arr = {3,4,5,6,7,8,0,1,2};
		 System.out.println(search(arr, 8));
	 }
}

package com.ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[1] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSumArray {
	
	public static void main(String[] args) {
		ThreeSumArray t = new ThreeSumArray();
		int []nums = {-1,0,1,2,-1,-4};
		///System.out.println("Result is :: "+ t.threeSum1(nums));
		System.out.println("Result is :: "+ t.threeSum2(nums));
	}
	
	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> uniqueNums = new HashSet<>();
		for(int i=0; i < nums.length; i++) {
			if(!uniqueNums.contains(nums[i])) {
				for(int j=i+1; j < nums.length; j++) {
					for(int k=j+1; k < nums.length; k++) {
						 if(nums[i] + nums[j] + nums[k] == 0) {
							 System.out.println(i + " " + j + " " + k);
							 StringBuilder s = new StringBuilder();
							 s.append(nums[i]).append(nums[j]).append(nums[k]);
								 List<Integer> triplet = new ArrayList<>();
								 triplet.add(nums[i]);
								 triplet.add(nums[j]);
								 triplet.add(nums[k]);
								 result.add(triplet);
						 }
					}
				}
				uniqueNums.add(nums[i]);
			}
		}
		return result;
	}
	
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0; i < nums.length; i++) {
			if(nums[i] <= 0 && (i == 0 || nums[i] != nums[i-1])) {
				//findPair(nums, i, result);
				findPair2(nums, i, result);
			}
		}
		return result;
	}
	
	private void findPair(int []nums, int index, List<List<Integer>>result) {
		
		int left=index + 1;
		int right = nums.length-1;
		while(left < right) {
			int sum = nums[index] + nums[left] + nums[right];
			if(sum < 0) {
				left++;
			} else if(sum > 0) {
				right--;
			} else {
				result.add(Arrays.asList(nums[index], nums[left], nums[right]));
				left++;
				right--;
				while(left < right && nums[left] == nums[left-1]) {
					left++;
				}
			}
		}
	}
	
	private void findPair2(int[] nums, int index, List<List<Integer>> result) {
		Set<Integer> visited = new HashSet<>();
		for(int j=index+1; j < nums.length; j++) {
			int complement = (nums[index] * -1) - nums[j];
			if(visited.contains(complement)) {
				result.add(Arrays.asList(nums[index], nums[j], complement));
				while(j+1 < nums.length && nums[j] == nums[j-1]) 
					j++;
			}
			visited.add(nums[j]);
		}
	}
}

package com.ds.leetcode.medium;

import java.util.Arrays;

public class SortedArrayRemoveDups {
	
	public static void main(String[] args) {
		SortedArrayRemoveDups s = new SortedArrayRemoveDups();
		int []nums = {0,0,1,1,1,1,2,2,3,3};
		//System.out.println("Result is :: "+ s.removeDuplicates2(nums));
		System.out.println("Result is :: "+ s.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
			
	}
	
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2) return nums.length;
	    
//	    int j = 2;
//	    for(int i = 2; i < nums.length; i++) {
//	      nums[j] = nums[i];
//	      if (nums[j] != nums[j - 2]) j++;
//	    }
//	    return j;
		int i = 1;
		for (int j = 2; j < nums.length; j++) {
			System.out.println(i + " " + j);
			if (nums[j] != nums[i-1]) {
				nums[++i] = nums[j];
			}
		}
		return i + 1;
    }

}

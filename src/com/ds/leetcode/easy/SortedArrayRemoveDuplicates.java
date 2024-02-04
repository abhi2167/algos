package com.ds.leetcode.easy;

import java.util.Arrays;

/**
 * 
	Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.


Remove duplicates from a sorted array and return length of array with unique chars
 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 
 {
   "pages":{
      "name":"Title 1",
      "description":"Test 1 content ",
      "children":[
         {
            "name":"Title 1",
            "description":"Test 1 content ",
            "children":[
               {
                  "name":"Title 1",
                  "description":"Test 1 content ",
                  "children": []
               }
            ]
         }
      ]
   }
}

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
 */
public class SortedArrayRemoveDuplicates {
	
	public static void main(String[] args) {
		SortedArrayRemoveDuplicates s = new SortedArrayRemoveDuplicates();
		int []nums = {0,1,1,1,2,3,3,4,4};
		//System.out.println("Result is :: "+ s.removeDuplicates2(nums));
		System.out.println("Result is :: "+ s.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
			
	}
	
    public int removeDuplicates2(int[] nums) {
    	if(nums.length <= 1)
    		return nums.length;
        int uniqueLen = 0;
        int i=0, j=1;
        while(j < nums.length) {
        	if(nums[i] != nums[j]) {
	        	while(i < j - 1) {
	        		i++;
	        		nums[i] = -101;
	        	}
	        	i++;
        	}
        	if(j == nums.length -1 && i != j) {
        		nums[j] = -101;
        	}
        	j++;
        }
        System.out.println(Arrays.toString(nums)); 
        return uniqueLen;
    }

    public int removeDuplicates(int[] nums) {
        int i=0, j=1;
        while(j < nums.length) {
        	if(nums[i] != nums[j]) {
	        	i++;
	        	nums[i] = nums[j];
        	}
        	j++;
        }
        System.out.println(i);
        System.out.println(Arrays.toString(nums)); 
        return i + 1;
    }
}

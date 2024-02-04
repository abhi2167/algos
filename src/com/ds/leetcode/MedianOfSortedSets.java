package com.ds.leetcode;

/**
	Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
	
	The overall run time complexity should be O(log (m+n)).
	
	 
	
	Example 1:
	
	Input: nums1 = [1,3], nums2 = [2]
	Output: 2.00000
	Explanation: merged array = [1,2,3] and median is 2.
	Example 2:
	
	Input: nums1 = [1,2], nums2 = [3,4]
	Output: 2.50000
	Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	 
	
	Constraints:
	
	nums1.length == m
	nums2.length == n
	0 <= m <= 1000
	0 <= n <= 1000
	1 <= m + n <= 2000
	-106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfSortedSets {

	public static void main(String[] args) {
		MedianOfSortedSets s  = new MedianOfSortedSets();
		int []nums1 = {2,5,7,9,11};
		int []nums2 = {4,6,8,10,15,20};
		System.out.println("Result is :: "+ s.findMedianSortedArrays(nums1, nums2));
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	double med1 = 0;
    	double med2 = 0;
    	int left = 0;
    	int right = 0;
    	double median = 0;
    	int result[] = new int[10];
    	med1 = findMedian(nums1);
    	med2 = findMedian(nums2);
    	left = (int) Math.min(med1, med2);
    	right = (int) Math.max(med1, med2);
    	// findNums(nums1, left, right);
    	// findNums(nums2, left, right);
    	median = findMedian(result);
        return median;
    }
    
    private double findMedian(int [] arr) {
    	double median = 0;
    	if(arr.length % 2 == 0) {
    		median = ((double)arr[(arr.length-1)/2] + arr[(arr.length-1)/2 + 1])/2;
    	} else {
    		median = arr[arr.length/2];
    	}
    	System.out.println("median "+ median);
    	return median;
    }
}

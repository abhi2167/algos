package com.ds.leetcode.Arrays.binarysearch;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays o = new MedianOfTwoSortedArrays();
        int nums1[] = {1,2,3,4,5,6,7,8};
        int nums2[] = {1,2,3,4};
        // 1,1,2,2,3, 3,4, 4,5,6,7,8 - total - 12 median is 6,7th element / 2

        System.out.println("Median of two sorted arrays = " + o.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int total = m+n;
        while(left <= right) {
            int Amid = (left+right)/2;
            int Bmid = (m+n+1)/2 - Amid;
            int maxLeftA = Amid ==0 ? Integer.MIN_VALUE : nums1[Amid-1];
            int minRightA = Amid == m ? Integer.MAX_VALUE : nums1[Amid];
            int maxLeftB = Bmid == 0 ? Integer.MIN_VALUE : nums2[Bmid-1];
            int minRightB = Bmid == n ? Integer.MAX_VALUE : nums2[Bmid];

            if(maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if(total % 2 == 0) {
                    return (
                            (Math.max(maxLeftA, maxLeftB) +
                                    Math.min(minRightA, minRightB)) /
                                    2.0
                    );
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = Amid-1;
            } else {
                left = Amid+1;
            }
        }
        return 0.0;
    }
}

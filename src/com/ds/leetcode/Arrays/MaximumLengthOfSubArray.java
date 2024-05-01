package com.ds.leetcode.Arrays;

public class MaximumLengthOfSubArray {

    public static void main(String[] args) {
        MaximumLengthOfSubArray m = new MaximumLengthOfSubArray();
        int[] nums1 = {9,8,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        System.out.println("Maximum length of sub array using top down = "+m.findLength(nums1, nums2));
        System.out.println("Maximum length of sub array using top down = "+m.findLength2(nums1, nums2));
    }

    public int findLength2(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int maxLen = 0;
        for(int left = -m+1; left < m+n-1; left++) {
            int count = 0;
            for(int right = 0; right < n; right++) {

                int actualLeft = left + right;
                System.out.println("left = " + left + " actualLeft = " + actualLeft + " right = " + right);
                if(actualLeft < 0) {
                    continue;
                }
                if(actualLeft >= m) {
                    break;
                }
                System.out.println("left value = " + nums1[actualLeft] +" right value = " + nums2[right]);
                if(nums1[actualLeft] == nums2[right]) {
                    count++;
                } else {
                    count = 0;
                }
                maxLen = Math.max(maxLen, count);

            }
            System.out.println("================================");
        }
        return maxLen;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        for(int row=0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(row == 0 ) {
                    dp[row][col] = nums1[row] == nums2[col] ? 1 : 0;
                } else if(col == 0) {
                    dp[row][col] = nums1[row] == nums2[col] ? 1 : 0;
                } else {
                    dp[row][col] = nums1[row] == nums2[col] ? 1 + dp[row-1][col-1] : 0;
                }
                max = Math.max(max, dp[row][col]);
            }
        }
        return max;
    }

}

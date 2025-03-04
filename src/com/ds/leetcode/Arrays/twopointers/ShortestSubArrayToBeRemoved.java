package com.ds.leetcode.Arrays.twopointers;

public class ShortestSubArrayToBeRemoved {

    public static void main(String[] args) {
        ShortestSubArrayToBeRemoved o = new ShortestSubArrayToBeRemoved();
        int [] arr = {1,2,3,10,4,2,3,5};
        System.out.println("length of shortest sub array to remove to make it non-decreasing = " + o.findLengthOfShortestSubarray(arr));
        System.out.println("length of shortest sub array to remove to make it non-decreasing = " + o.findLengthOfShortestSubarray_bin(arr));
    }

    public int findLengthOfShortestSubarray_bin(int[] arr) {
        int minLen = Integer.MAX_VALUE;
        int n = arr.length;
        int right = n-1;
        while(right > 0 && arr[right] >= arr[right-1]) right--;
        int left = 0;
        while(left+1 < n && arr[left] <= arr[left+1]) left++;

        if(left >= right) {
            return 0;
        }
        minLen = Math.min((n-left+1), right);
        for(int i = 0; i <= left; i++) {
            int target = arr[i];
            int rightBound = binSearch(arr, right, n, target);
            minLen = Math.min(minLen, rightBound-(i+1));
        }
        return minLen;
    }

    private int binSearch(int[] arr, int left, int right, int target) {
        while(left < right) {
            int mid = left + (right-left)/2;
            if(arr[mid] >= target) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int minLen = Integer.MAX_VALUE;
        int n = arr.length;
        int right = n-1;
        while(right > 0 && arr[right] >= arr[right-1]) right--;
        int left = 0;
        minLen = right;


        while(left < right && (left == 0 || arr[left] >= arr[left-1]) ) {
            while(right < n && arr[left] > arr[right]) {
                right++;
            }
            minLen = Math.min(minLen, right-left-1);
            left++;
        }
        return minLen;
    }
}

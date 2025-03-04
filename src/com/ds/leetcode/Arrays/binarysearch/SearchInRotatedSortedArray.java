package com.ds.leetcode.Arrays.binarysearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray o = new SearchInRotatedSortedArray();
        //int []nums = {5,6,7,0,1,2,4};
        int []nums = {6,7,0,1,2,4,5};
        int target = 4;
        System.out.println("index of target in rotated array = " + o.search(nums, target));
        System.out.println("index of target in rotated array = " + o.search_by_shift(nums, target));
        System.out.println("index of target in rotated array = " + o.one_binary_search(nums, target));
    }

    public int one_binary_search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[left]) {
                if(target < nums[mid] && target >= nums[left]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public int search_by_shift(int[] nums, int target) {
        int n = nums.length;
        int minIndex = getMinElementIndex(0, n-1, nums);
        int shift = n-minIndex;
        int left = (minIndex + shift)%n; // always results in zero
        int right = (minIndex-1+shift)%n;
        int mid;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(nums[ (mid-shift+n) % n ] == target) {
                return mid-shift;
            } else if(nums[ (mid-shift + n)%n] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int right = n-1;
        int left = getMinElementIndex(0, right, nums);

        System.out.println("min element  = " + nums[left]);
        // search right sorted array
        int targetIndex = binarySearch(nums, left, n-1, target);
        if(targetIndex == -1) {
            // search left sorted array
            targetIndex = binarySearch(nums, 0, left-1, target);
        }
        return targetIndex;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int mid;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getMinElementIndex(int left, int right, int[] nums) {
        int mid;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

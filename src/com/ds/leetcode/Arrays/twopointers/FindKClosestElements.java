package com.ds.leetcode.Arrays.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindKClosestElements {

    public static void main(String[] args) {
        FindKClosestElements o = new FindKClosestElements();
        int[] arr = {1,3};
        int k = 1;
        int x = 2;
        System.out.println("k closest elements to target x " + x + " in list nums : " + o.findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int closestIndexToX = binSearch(arr, x);
        int left = closestIndexToX-1;
        int right = closestIndexToX+1;
        while(right-left+1 < k) {
            if(left == -1) {
                right++;
                continue;
            }
            if(right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }
        for(int i = left+1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    private int binSearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        int mid;
        while(left < right) {
            mid = (left+right)/2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}

package com.ds.leetcode.Arrays.binarysearch;

import java.util.Arrays;
import java.util.Map;

public class SumOfMutatedTargetArray {

    public static void main(String[] args) {
        SumOfMutatedTargetArray o = new SumOfMutatedTargetArray();
        int arr[] = {4,9,3};
        int target = 10;
        System.out.println("Sum of mutated target array = " + o.findBestValue(arr, target));
    }

    public int findBestValue(int[] arr, int target) {
        int closestValue = Integer.MAX_VALUE;
        int right = 0;
        for(int num : arr) {
            right = Math.max(right, num);
        }
        if(Arrays.stream(arr).sum() == target) {
            return right;
        }
        int left = 0;
        int mid;
        int currentSum;
        int diff = Integer.MAX_VALUE;
        while (left <= right) {
            mid = left + (right-left)/2;
            currentSum = findSum(arr, mid);
            if(currentSum >= target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
            if(Math.abs(target - currentSum) < Math.abs(target-diff) || (mid < closestValue && Math.abs(target - currentSum) <= Math.abs(target-diff))) {
                diff = currentSum;
                closestValue = mid;
            }
        }
        return closestValue;
    }

    private int findSum(int[] arr, int max) {
        int sum = 0;
        for(int num : arr) {
            sum += num > max ? max : num;
        }
        return sum;
    }
}

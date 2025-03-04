package com.ds.leetcode.Arrays.twopointers;

import java.util.*;

public class ThreeSumWithMultiplicity {

    public static void main(String[] args) {
        ThreeSumWithMultiplicity o = new ThreeSumWithMultiplicity();
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        System.out.println("Number of tuples that sum up to target  = " + o.threeSumMulti_btf(arr, target));
        System.out.println("Number of tuples that sum up to target  = " + o.threeSumMulti_usingHashSet(arr, target));
        System.out.println("Number of tuples that sum up to target  = " + o.threeSumMulti_usingTwoPointer(Arrays.copyOf(arr, arr.length), target));
    }

    static int mod = 1_000_000_007;

    public int threeSumMulti_usingTwoPointer(int[] arr, int target) {
        int ans = 0;
        Arrays.sort(arr);
        int currentCount = 0;
        for(int i = 0; i < arr.length; i++) {
            currentCount = twoSumTwoPointers(arr, target - arr[i], i+1);
            ans += currentCount;
            ans %= mod;
        }
        return ans;
    }

    private int twoSumTwoPointers(int[] arr, int target, int currentIndex) {
        int ans = 0;
        int left = currentIndex;
        int right = arr.length-1;
        int sum = 0;
        while(left < right) {
            sum = arr[left] + arr[right];
            if(sum == target) {
                if(arr[left] != arr[right]) {
                    int leftDupCount = 1;
                    int rightDupCount = 1;
                    while(left+1 < right && arr[left] == arr[left+1]) {
                        leftDupCount++;
                        left++;
                    }
                    while(right-1 > left && arr[right] == arr[right-1]) {
                        right--;
                        rightDupCount++;
                    }
                    ans += leftDupCount * rightDupCount;
                    ans %= mod;
                    left++;
                    right--;
                } else {
                    ans += (right-left+1) * (right-left)/2;
                    ans %= mod;
                    break;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public int threeSumMulti_usingHashSet(int[] arr, int target) {
        int ans = 0;

        int currentCount = 0;
        for(int i = 0; i < arr.length; i++) {
            currentCount = twoSum(arr, target - arr[i], i+1);
            ans += currentCount;
            ans %= mod;
        }
        return ans;
    }

    private int twoSum(int[] arr, int target, int currentIndex) {
        int ans = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = currentIndex; i < arr.length; i++) {
            if(seen.containsKey(target - arr[i])) {
                ans += seen.get(target-arr[i]);
                ans %= mod;
            }
            seen.put(arr[i], seen.getOrDefault(arr[i], 0) + 1);
        }

        return ans;
    }

    public int threeSumMulti_btf(int[] arr, int target) {
        int ans = 0;
        int mod = 1_000_000_007;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                for(int k = j+1; k < arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == target) {
                        ans++;
                        ans %= mod;
                    }
                }
            }
        }
        return ans;
    }
}

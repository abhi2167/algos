package com.ds.leetcode.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteAndEarn {
    public static void main(String[] args) {
        DeleteAndEarn d = new DeleteAndEarn();
        int nums[] = {2,2,3,3,3,4,9, 100};
        //System.out.println("Max number of points that can be earned from deletes " + d.deleteAndEarn_bruteforce(nums));
        System.out.println("Max number of points that can be earned from deletes " + d.deleteAndEarn_tp(nums));
        System.out.println("Max number of points that can be earned from deletes " + d.deleteAndEarn_bu(nums));
        System.out.println("Max number of points that can be earned from deletes " + d.deleteAndEarn_bu_space_optimized(nums));
    }


    public int deleteAndEarn_bu_space_optimized(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();

        int maxNum = Integer.MIN_VALUE;
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        int prevTwoResult = 0;
        int prevOneResult = points.getOrDefault(1, 0);
        int result = Math.max(prevOneResult, prevTwoResult);
        for(int i = 2; i <= maxNum; i++) {
            int currentGain = points.getOrDefault(i,0);
            result = Math.max( currentGain + prevTwoResult, prevOneResult);
            prevTwoResult = prevOneResult;
            prevOneResult = result;
        }
        return result;
    }

    public int deleteAndEarn_bu(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();

        int maxNum = Integer.MIN_VALUE;
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        int[] dp = new int[maxNum+1];
        dp[0] = 0;
        dp[1] = points.getOrDefault(1, 0);
        for(int i = 2; i < dp.length; i++) {
            int currentGain = points.getOrDefault(i,0);
            dp[i] = Math.max( currentGain + dp[i-2], dp[i-1]);
        }
        return dp[maxNum];
    }

    public int deleteAndEarn_tp(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        HashMap<Integer, Integer> cache = new HashMap<>();

        int maxNum = Integer.MIN_VALUE;
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
            points.put(num, points.getOrDefault(num, 0) + num);
        }
        int res = deleteAndEarn(points, cache, maxNum);
        System.out.println(points);
        System.out.println(cache);
        return  res;
    }

    private int deleteAndEarn(HashMap<Integer, Integer> points, HashMap<Integer, Integer> cache, int num) {
        if(num == 0) {
            return 0;
        }
        if(num == 1) {
            return points.getOrDefault(1, 0);
        }
        if(cache.containsKey(num)) {
            return cache.get(num);
        }
        int currentGain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(currentGain + deleteAndEarn(points, cache,num - 2), deleteAndEarn(points, cache,num-1)));
        return  cache.get(num);
    }

    // Brute force using recursion
    public int deleteAndEarn_bruteforce(int[] nums) {
        return deleteAndEarn(nums, 0);
    }

    public int deleteAndEarn(int[] nums, int currentIndex) {
        if(nums.length == 0 || currentIndex >= nums.length) {
            return 0;
        }
        if(nums.length == 1) {
            return  nums[0];
        }
        System.out.println(" Current Index " + currentIndex);
        int currentNum = nums[currentIndex];
        return Math.max(currentNum + deleteAndEarn(newArray(nums, currentIndex, currentNum), 0),
                deleteAndEarn(nums, currentIndex+1));
    }

    private int[] newArray(int[] nums, int currentIndex, int currentNum) {
        List<Integer> newNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        newNums.remove(currentIndex);
        int temp[] = newNums.stream().filter(num -> num != currentNum+1 && num != currentNum - 1).mapToInt(i -> i).toArray();
        return  temp;
    }
}

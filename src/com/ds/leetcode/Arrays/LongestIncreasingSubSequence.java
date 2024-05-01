package com.ds.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        LongestIncreasingSubSequence s = new LongestIncreasingSubSequence();
        int [] nums = {10,9,2,5,3,7,1,101,18};
        System.out.println("Longest increasing sub sequence " + s.lengthOfLIS(nums));
        System.out.println("Longest increasing sub sequence " + s.lengthOfLIS_bu_intelligent_seq(nums));
    }

    public int lengthOfLIS_bu_intelligent_seq(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            if(currentNum > sub.get(sub.size()-1)) {
                sub.add(currentNum);
            } else {
                int j = binarySearch(sub, currentNum);
//                int j = 0;
//                while(currentNum > sub.get(j)) {
//                    j++;
//                }
                sub.set(j, currentNum);
            }
        }
        return  sub.size();
    }

    private int binarySearch(List<Integer> sub, int currentNum) {
        int left = 0;
        int right = sub.size()-1;
        int mid = 0;
        while(left < right) {
            mid = (left + right)/2;
            if(sub.get(mid) == currentNum) {
                return mid;
            } else if ( sub.get(mid) > currentNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int currNum = nums[i];
            dp[i] = 1;
            for(int j=i-1; j >=0; j--) {
                if(currNum > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int maxSeq = 0;
        maxSeq = Arrays.stream(dp).max().getAsInt();
        System.out.println(Arrays.toString(dp));
        return  maxSeq;
    }
}

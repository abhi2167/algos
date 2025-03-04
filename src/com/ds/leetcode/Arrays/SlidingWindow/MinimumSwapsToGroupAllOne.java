package com.ds.leetcode.Arrays.SlidingWindow;

public class MinimumSwapsToGroupAllOne {

    public static void main(String[] args) {
        MinimumSwapsToGroupAllOne o = new MinimumSwapsToGroupAllOne();
        int [] data = {1,0,1,0,1,0,0,1,1,0,1};
        System.out.println("minimum swaps to group all one = " + o.minSwaps(data));
    }

    public int minSwaps(int[] data) {
        int requiredLen = 0;
        for(int i = 0; i < data.length; i++) {
            requiredLen += data[i] == 1 ? 1 : 0;
        }
        int countOfOne = 0;
        for(int i = 0; i < requiredLen; i++) {
            countOfOne += data[i] == 1 ? 1 : 0;
        }
        int maxOne = countOfOne;
        for(int i = requiredLen; i < data.length; i++) {
            countOfOne += data[i] == 1 ? 1 : 0;
            countOfOne -= data[i-requiredLen] == 1 ? 1 : 0;
            maxOne = Math.max(maxOne, countOfOne);
        }
        return requiredLen - maxOne;
    }
}

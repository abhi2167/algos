package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class ShortestDistanceToChar {

    public static void main(String[] args) {
        ShortestDistanceToChar o = new ShortestDistanceToChar();
        String s = "loveleetcode";
        char c = 'e';
        System.out.println("shortest distance to char c " + Arrays.toString(o.shortestToChar(s, c)));
    }

    public int[] shortestToChar(String s, char c) {
        int [] ans = new int[s.length()];
        int prev = Integer.MIN_VALUE/2;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = i - prev;

        }
        prev = Integer.MAX_VALUE/2;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = Math.min(ans[i], prev-i);
        }
        return ans;
    }
}

package com.ds.leetcode.Strings;

import java.util.Arrays;
import java.util.stream.Stream;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s = "123123";
        System.out.println("Number of ways to decode top down " + d.numDecodings(s));
        System.out.println("Number of ways to decode bottom up " + d.numDecodings_bu(s));
        System.out.println("Number of ways to decode bottom up effective " + d.numDecodings_bu_effective(s));
    }

    public int numDecodings_bu_effective(String s) {
        int n = s.length() + 1;
        int twoCharDecode = 1;
        int oneCharDecode = s.charAt(n-2) == '0' ? 0 : 1;
        for(int i = n-3; i >=0; i--) {
            int temp = oneCharDecode;
            if(s.charAt(i) == '0') {
                twoCharDecode = temp;
                oneCharDecode = 0;
            } else if( i+2 <= s.length() && Integer.parseInt(s.substring(i, i+2)) <= 26) {
                oneCharDecode = oneCharDecode + twoCharDecode;
                twoCharDecode = temp;
            } else {
                twoCharDecode = oneCharDecode;
            }
        }
        return oneCharDecode;
    }

    public int numDecodings_bu(String s) {
        int n = s.length() + 1;
        int[] dp = new int[n];
        dp[n-1] = 1;
        dp[n-2] = s.charAt(n-2) == '0' ? 0 : 1;
        for(int i = n-3; i >=0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            } else if( i+2 <= s.length() && Integer.parseInt(s.substring(i, i+2)) <= 26) {
                dp[i] = dp[i+1] + dp[i+2];
            } else {
                dp[i] = dp[i+1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        int res = numDecodings(s, 0, dp);
        System.out.println(Arrays.toString(dp));
        return  res;
    }

    private int numDecodings(String s, int currentIndex, int[] dp) {
        if(currentIndex > s.length() || (currentIndex < s.length() && s.charAt(currentIndex) == '0')) {
            return 0;
        }
        if(currentIndex == s.length()) {
            dp[currentIndex] = 1;
            return 1;
        }
        if(dp[currentIndex] != 0) {
            return dp[currentIndex];
        }
        int p1 = numDecodings(s, currentIndex+1, dp);
        int p2 = 0;
        if( currentIndex+2 <= s.length() && Integer.parseInt(s.substring(currentIndex, currentIndex+2)) <= 26) {
            p2 = numDecodings(s, currentIndex+2, dp);
        }
        return dp[currentIndex] = p1 + p2;
    }
}

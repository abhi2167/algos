package com.ds.leetcode.Arrays.twopointers;

public class CountBinarySubStrings {

    public static void main(String[] args) {
        CountBinarySubStrings o = new CountBinarySubStrings();
        String s = "110001111000000";
        System.out.println("number of symmetrical binary strings " + o.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int index = 0;
        groups[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                index++;
                groups[index] = 1;
            } else {
                groups[index]++;
            }
        }
        int count = 0;
        for(int i = 1; i <= index; i++) {
            count += Math.min(groups[i], groups[i-1]);
        }
        return count;
    }
}

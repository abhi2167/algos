package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring o = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(" min window substring of s that has all chars from t = " + o.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> tCharMap = new HashMap<>();
        HashMap<Character, Integer> sCharMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            tCharMap.put(t.charAt(i), tCharMap.getOrDefault(t.charAt(i), 0)+1);
        }
        int left = 0;
        int right = 0;
        int formed = 0;
        int required = tCharMap.size();
        String res = "";
        int minLen = Integer.MAX_VALUE;

        while(right < s.length()) {
            char currentCh = s.charAt(right);

            sCharMap.put(currentCh, sCharMap.getOrDefault(currentCh,0)+1);
            if(tCharMap.containsKey(currentCh) && sCharMap.get(currentCh).intValue() == tCharMap.getOrDefault(currentCh,0).intValue()) {
                formed++;
            }
            while(left <= right && formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left +1;
                    res = s.substring(left, right+1);
                }
                char ch = s.charAt(left);
                sCharMap.put(ch, sCharMap.getOrDefault(ch, 0)-1);
                if(tCharMap.containsKey(ch) && sCharMap.get(ch).intValue() < tCharMap.get(ch).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return res;
    }

}

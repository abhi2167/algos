package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class MaxVowelsInWindow {

    public static void main(String[] args) {
        MaxVowelsInWindow m = new MaxVowelsInWindow();
        String s = "abciiidef";
        int k = 3;
        System.out.println(m.maxVowels(s, k));
    }

    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int currentCount = 0;
        while(right < s.length()) {
            if(isVowel(s.charAt(right))) {
                currentCount++;
            }
            if(right - left + 1 < k) {
                right++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount -= isVowel(s.charAt(left)) ? 1 : 0;
                left++;
                right++;
            }
        }
        return maxCount;
    }

    Set<Character> vowels = Set.of('a','e','i','o','u');

    private boolean isVowel(char c) {
        return  vowels.contains(c);
    }
}

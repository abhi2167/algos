package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class SubStringsWithDistinctChars {

    public static void main(String[] args) {
        SubStringsWithDistinctChars s = new SubStringsWithDistinctChars();
        String input = "aababcabc";
        System.out.println("Sub strings with chars " + s.countGoodSubstrings(input));
        System.out.println("Sub strings with chars " + s.countGoodSubstrings_eff(input));
    }

    public int countGoodSubstrings_eff(String s) {
        int left = 0;
        int right = 0;
        int[] charFreq = new int[26];
        int result = 0;

        while ( right < s.length()) {
            int currentChIndex = s.charAt(right) - 'a';
            charFreq[currentChIndex]++;
            while(charFreq[currentChIndex] > 1) {
                int leftCharIndex = s.charAt(left) - 'a';
                charFreq[leftCharIndex]--;
                left++;
            }
            if(right-left+1 == 3) {
                int leftCharIndex = s.charAt(left) - 'a';
                charFreq[leftCharIndex]--;
                left++;
                result++;
            }
            right++;
        }
        return result;
    }
    public int countGoodSubstrings(String s) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> chars = new HashMap<>();
        int result = 0;

        while ( right < s.length()) {
            char ch = s.charAt(right);
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
            if ( right - left + 1 < 3) {
                right++;
            } else {
                if ( chars.size() == 3) {
                    result++;
                }
                chars.put(s.charAt(left), chars.get(s.charAt(left))-1);
                if(chars.get(s.charAt(left)) == 0) {
                    chars.remove(s.charAt(left));
                }
                left++;
                right++;
            }
        }
        return result;
    }
}



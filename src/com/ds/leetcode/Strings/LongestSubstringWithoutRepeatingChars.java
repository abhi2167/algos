package com.ds.leetcode.Strings;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars l = new LongestSubstringWithoutRepeatingChars();
        String s = "esdvcdefg";
        System.out.println("Longest substring without repeating chars length = " + l.lengthOfLongestSubstring(s));
        System.out.println("Longest substring without repeating chars length = " + l.lengthOfLongestSubstring_eff(s));
        System.out.println("Longest substring without repeating chars length using array = " + l.lengthOfLongestSubstring_arr_instead_of_hashmap(s));
    }

    public int lengthOfLongestSubstring_arr_instead_of_hashmap(String s) {
        if(s.length() <=1 ) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int[] count = new int[26];
        while(right < s.length()) {
            int chIndex = s.charAt(right) - 'a';
            count[chIndex]++;
            while(count[chIndex] > 1) {
                char l = s.charAt(left);
                count[l-'a']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;

        }
        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() <=1 ) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        while(right < s.length()) {
            char ch = s.charAt(right);
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
            while(seen.get(ch) > 1) {
                char l = s.charAt(left);
                seen.put(l, seen.get(l) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;

        }
        return maxLength;
    }

    public int lengthOfLongestSubstring_eff(String s) {
        if(s.length() <=1 ) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(seen.containsKey(ch)) {
                left = Math.max(seen.get(ch), left);
            }
            seen.put(ch, right+1);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;

        }
        return maxLength;
    }
}

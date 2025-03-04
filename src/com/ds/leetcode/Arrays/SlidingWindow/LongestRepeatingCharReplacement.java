package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashSet;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharReplacement o = new LongestRepeatingCharReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println("Longest repeating char with k replacments = " + o.characterReplacement_bin_search(s, k));
        System.out.println("Longest repeating char with k replacments = " + o.characterReplacement_sliding_window(s, k));
        System.out.println("Longest repeating char with k replacments = " + o.characterReplacement_sliding_window_slow(s, k));
    }

    public int characterReplacement_sliding_window_slow(String s, int k) {
        if(s.length() <= 1) {
            return s.length();
        }
        HashSet<Character> uniqueLetters = new HashSet<>();
        for(int i=0; i < s.length(); i++) {
            uniqueLetters.add(s.charAt(i));
        }
        int maxLen = 0;
        for(Character uniqueLetter : uniqueLetters) {

            int left = 0;
            int right = 0;
            int count = 0;
            while(right < s.length()) {
                char currentCh = s.charAt(right);
                if(currentCh == uniqueLetter) {
                    count++;
                }
                while(!isWindowValid(k, left, right, count)) {
                    char leftCh = s.charAt(left);
                    if(leftCh == uniqueLetter) {
                        count--;
                    }
                    left++;
                }
                maxLen = Math.max(maxLen, right-left+1);
                right++;
            }
        }
        return maxLen;
    }

    private static boolean isWindowValid(int k, int left, int right, int count) {
        return (right - left + 1 - count) <= k;
    }

    public int characterReplacement_sliding_window(String s, int k) {
        if(s.length() <= 1) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int[] freqMap = new int[26];
        int maxFreq = 0;
        int lenOfLongestSubStr = 0;
        while(right < s.length()) {
            int currentCh = s.charAt(right) - 'A';
            freqMap[currentCh]++;
            maxFreq = Math.max(maxFreq, freqMap[currentCh]);
            boolean isValid = (right + 1 - left - maxFreq) <= k;
            if(!isValid) {
                int leftCh = s.charAt(left) - 'A';
                freqMap[leftCh]--;
                left++;
            }
            lenOfLongestSubStr = right+1-left;
            right++;
        }
        return lenOfLongestSubStr;
    }

    public int characterReplacement_bin_search(String s, int k) {
        int low = 1;
        int high = s.length()+1;
        while(low+1 < high) {
            int mid = (low+high)/2;
            if(isValid(s, mid, k)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private boolean isValid(String s, int mid, int k) {
        int left = 0;
        int right = 0;
        int subStrLen = mid;
        int maxFreq = 0;
        int[] freqMap = new int[26];
        while(right < s.length()) {
            int currentCh = s.charAt(right) - 'A';
            freqMap[currentCh]++;
            maxFreq = Math.max(maxFreq, freqMap[currentCh]);
            if(right-left+1 > subStrLen) {
                int leftCh = s.charAt(left) - 'A';
                freqMap[leftCh]--;
                left++;
            }
            if(subStrLen - maxFreq <= k) {
                return true;
            }
            right++;
        }
        return false;
    }
}

package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxOccurancesOfSubString {
    public static void main(String[] args) {
        MaxOccurancesOfSubString o = new MaxOccurancesOfSubString();
        String s = "aabbaabaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;
        System.out.println("Max occurrances of substring with given letters and size = " + o.maxFreq(s, maxLetters, minSize, maxSize));
        System.out.println("=======================================================================");
        System.out.println("Max occurrances of substring with given letters and size 2 = " + o.maxFreq2(s, maxLetters, minSize, maxSize));
        System.out.println("Max occurrances of substring with given letters and size 2 = " + o.maxFreq4(s, maxLetters, minSize, maxSize));
        System.out.println("Max occurrances of substring with given letters and size 2 = " + o.maxFreq6(s, maxLetters, minSize, maxSize));
    }

    public int maxFreq6(String s, int maxLetters, int minSize, int maxSize) {

        int[] ch = new int[26];
        int Letters=0,NoOfOccurrence=0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0,j=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(++ch[c-'a']==1) {
                Letters++;
            }
            while(Letters>maxLetters) {
                if(--ch[s.charAt(j)-'a']==0) Letters--;
                j++;
            }
            while(i-j+1>=minSize) {
                String s1=s.substring(j,i+1);
                map.put(s1,map.getOrDefault(s1,0)+1);
                NoOfOccurrence=Math.max(NoOfOccurrence,map.get(s1));
                if(--ch[s.charAt(j)-'a']==0) Letters--;
                j++;
            }
        }
        System.out.println("word frequency map " + map);
        return NoOfOccurrence;
    }

    // if a substring of max length k is repeated n times, then there will always be a substring of min length x repeated n times
    // Hence we can find the most repeated substring of min length which leads us to the answer.
    // There is no need for range scan from min to max;
    public int maxFreq5(String s, int maxLetters, int minSize, int maxSize) {

        Map<String, Integer> wordDict = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i < s.length()-minSize+1; i++) {
            String subStr = s.substring(i, i + minSize);
            Set<Character> uniqueLetters = new HashSet<>();
            for(int j=0; j < minSize; j++) {
                char ch = subStr.charAt(j);
                uniqueLetters.add(ch);
            }
            if(uniqueLetters.size() <= maxLetters) {
                wordDict.put(subStr, wordDict.getOrDefault(subStr, 0)+1);
                maxFreq = Math.max(maxFreq, wordDict.get(subStr));
            }
        }
        return maxFreq;
    }
    public int maxFreq4(String s, int maxLetters, int minSize, int maxSize) {
        int maxFreq = 0;
        Map<String, Integer> wordDict = new HashMap<>();
        for(int size = minSize; size <= maxSize; size++) {
            int left = 0, right = 0;
            Map<Character, Integer> uniqueLetters = new HashMap<>();

            while(right < s.length()) {
                char currentCh = s.charAt(right);
                uniqueLetters.put(currentCh, uniqueLetters.getOrDefault(currentCh,0)+1);
                int windowSize = right - left + 1;
                if(windowSize == size) {
                    if(uniqueLetters.size() <= maxLetters) {
                        String subStr = s.substring(left, right+1);
                        wordDict.put(subStr, wordDict.getOrDefault(subStr, 0) + 1);
                        maxFreq = Math.max(maxFreq, wordDict.get(subStr));
                    }
                    char leftChar = s.charAt(left);
                    uniqueLetters.put(leftChar, uniqueLetters.get(leftChar)-1);
                    if(uniqueLetters.get(leftChar) == 0) {
                        uniqueLetters.remove(leftChar);
                    }
                    left++;
                }
                right++;
            }
        }

        return maxFreq;
    }
    // sliding window - reuses previous computation
    public int maxFreq2(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        int maxFreq = 0;
        Map<String, Integer> wordDict = new HashMap<>();
        Map<Character, Integer> uniqueLetters = new HashMap<>();
        int left = 0, right = 0;
        int k = minSize;
        StringBuilder subStr = new StringBuilder();
        while(right <= n-minSize) {
            k = minSize;
            while (k <= maxSize) {
                if(right == 0 && k == minSize) {
                    for(char ch : s.substring(0, k).toCharArray()) {
                        uniqueLetters.put(ch, uniqueLetters.getOrDefault(ch,0)+1);
                        subStr.append(ch);
                    }
                    System.out.println(subStr);
                    if (uniqueLetters.size() <= maxLetters) {
                        wordDict.put(subStr.toString(), wordDict.getOrDefault(subStr.toString(), 0) + 1);
                        maxFreq = Math.max(maxFreq, wordDict.getOrDefault(subStr.toString(), 0));
                    }
                } else if (right+k <= n) {
                    char ch = s.charAt(right+k-1);
                    subStr.append(ch);
                    System.out.println(subStr);
                    uniqueLetters.put(ch, uniqueLetters.getOrDefault(ch,0)+1);
                    if(uniqueLetters.size() <= maxLetters) {
                        wordDict.put(subStr.toString(), wordDict.getOrDefault(subStr.toString(), 0) + 1);
                        maxFreq = Math.max(maxFreq, wordDict.getOrDefault(subStr.toString(), 0));
                    } else {
                        break;
                    }
                }
                k++;
            }

            if(!subStr.isEmpty() && subStr.length() >= minSize) {
                for(int i=subStr.length()-1; i >= minSize;i--) {
                    char ch = subStr.charAt(i);
                    uniqueLetters.put(ch, uniqueLetters.getOrDefault(ch,0)-1);
                    if(uniqueLetters.get(ch) == 0) {
                        uniqueLetters.remove(ch);
                    }
                    subStr.deleteCharAt(i);
                }
                char ch = subStr.charAt(0);
                uniqueLetters.put(ch, uniqueLetters.getOrDefault(ch,0)-1);
                if(uniqueLetters.get(ch) == 0) {
                    uniqueLetters.remove(ch);
                }
                subStr.deleteCharAt(0);
            }
            right++;
        }
        return maxFreq;
    }

    // sliding window

    public int maxFreq3(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        int maxFreq = 0;
        Map<String, Integer> wordDict = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();

        int uniqueLetters = 0;

        for(int subStrLen = minSize; subStrLen <= maxSize; subStrLen++) {

            for(int i = 0; i < subStrLen; i++) {
                char ch = s.charAt(i);
                charCount.put(ch, charCount.getOrDefault(ch,0)+1);
                if(charCount.get(ch) == 1) {
                    uniqueLetters++;
                }
            }

            if(uniqueLetters <= maxLetters) {
                String subStr = s.substring(0, subStrLen);
                wordDict.put(subStr, wordDict.getOrDefault(subStr, 0) + 1);
                maxFreq = Math.max(maxFreq, wordDict.getOrDefault(subStr, 0));
            }

            for(int i = subStrLen; i < s.length(); i++) {
                char newChar = s.charAt(i);
                charCount.put(newChar, charCount.getOrDefault(newChar,0)+1);
                if(charCount.get(newChar) == 1) {
                    uniqueLetters++;
                }
                char oldChar = s.charAt(i-subStrLen);
                charCount.put(oldChar, charCount.getOrDefault(oldChar,0) - 1);
                if(charCount.get(oldChar) == 0) {
                     uniqueLetters--;
                }
                if(uniqueLetters <= maxLetters) {
                    String subStr = s.substring(i-subStrLen+1,i+1);
                    wordDict.put(subStr, wordDict.getOrDefault(subStr, 0)+1);
                    maxFreq = Math.max(wordDict.getOrDefault(subStr, 0), maxFreq);
                }
            }

        }
        return maxFreq;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        int maxFreq = 0;
        Map<String, Integer> wordDict = new HashMap<>();

        for(int subStrLen = minSize; subStrLen <= maxSize; subStrLen++) {
            for(int j = 0; j <= n - subStrLen; j++) {
                String subStr = s.substring(j, j + subStrLen);
                System.out.println(subStr);
                if(isValid(subStr, maxLetters)) {
                    wordDict.put(subStr, wordDict.getOrDefault(subStr, 0) + 1);
                    maxFreq = Math.max(maxFreq, wordDict.get(subStr));
                }
            }
        }
        return maxFreq;
    }

    private boolean isValid(String subStr, int maxLetters) {

        Set<Character> letters = new HashSet<>();
        for(int i = 0; i < subStr.length(); i++) {
            letters.add(subStr.charAt(i));
            if(letters.size() > maxLetters) {
                return false;
            }
        }
        return true;
    }
}

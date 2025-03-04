package com.ds.leetcode.Arrays.SlidingWindow;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class FindAllAnagramsOfString {

    public static void main(String[] args) {
        FindAllAnagramsOfString o = new FindAllAnagramsOfString();
        String s = "cabebabacd";
        String p = "abc";
        // baccd
        // abeccd

        long now = System.currentTimeMillis();
        System.out.println("Anagrams of string p in string s are = " + o.findAnagrams(s, p));
        System.out.println("Anagrams of string p in string s using arrays are = " + o.findAnagrams2_usingArrays(s, p));
    }

    public List<Integer> findAnagrams2_usingArrays(String s, String p) {

        int n = s.length();
        int k = p.length();
        int left = 0;
        int right = 0;
        int[] schars = new int[26];
        int[] pChars = new int[26];
        for(int i = 0; i < p.length(); i++) {
            pChars[p.charAt(i) - 'a']++;
        }
        List<Integer> answer = new ArrayList<>();
        while(right < n ) {
            char ch = s.charAt(right);
            schars[ch-'a']++;
            if(right-left+1 == k ) {
                if(Arrays.equals(schars, pChars)) {
                    answer.add(left);
                }
                char leftChar = s.charAt(left);
                schars[leftChar-'a']--;
                left++;
            }
            right++;
        }
        return answer;
    }

    public List<Integer> findAnagrams(String s, String p) {

        int n = s.length();
        int k = p.length();
        int left = 0;
        int right = 0;
        Map<Character, Integer> pCharMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            pCharMap.put(p.charAt(i), pCharMap.getOrDefault(p.charAt(i), 0)+1);
        }
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        while(right < n ) {
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch,0)+1);
            if(right-left+1 == k ) {
                if(sMap.equals(pCharMap)) {
                    answer.add(left);
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.getOrDefault(leftChar, 0)-1);
                if(sMap.get(leftChar) == 0) {
                    sMap.remove(leftChar);
                }
                left++;
            }
            right++;
        }
        return answer;
    }
}

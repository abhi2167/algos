package com.ds.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence s = new IsSubsequence();
        String str = "abc";
        String t = "ahbgdcc";
        System.out.println("is subsequence result = " + s.isSubsequence(str, t));
        System.out.println("is subsequence2 result = " + s.isSubsequence2(str, t));
    }

    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;
        int m = s.length();
        int n = t.length();
        while(left < m && right < n) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
            }
        }
        return left == m;
    }

    public boolean isSubsequence2(String s, String t) {
        Map<Character, List<Integer>> letters = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            letters.computeIfAbsent(ch, (c) -> new ArrayList<>());
            letters.get(ch).add(i);
        }
        System.out.println(letters);

        int currentMatchIndex = -1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!letters.containsKey(ch)) {
                return false;
            }
            boolean isMatched = false;

            for(int matchIndex : letters.get(ch)) {
                if(currentMatchIndex < matchIndex) {
                    currentMatchIndex = matchIndex;
                    isMatched = true;
                    break;
                }
            }

            if(!isMatched) {
                return false;
            }
        }

        return true;
    }
}

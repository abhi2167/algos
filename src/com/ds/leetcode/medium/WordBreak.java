package com.ds.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

 *
 */
public class WordBreak {
	
	public static void main(String[] args) {
//		WordBreak w = new WordBreak();
//		String s = "applepenapplep";
//		List<String> wordDict = new ArrayList<>();
//		wordDict.add("apple");
//		wordDict.add("pen");
		
		WordBreak w = new WordBreak();
		String s = "catsanddog"; //glassesglass // aaa a aaa aaa aaa // catss
		/*
		 * last index = 3 aaaa
		 * last index = 3, 6, 9
		 */
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		System.out.println("Result is :: "+ w.wordBreak(s, wordDict));
		System.out.println("Result is :: "+ w.wordBreak3(s, wordDict));
	}
	
    public boolean wordBreak2(String s, List<String> wordDict) {
    	Set<String> words = new HashSet<>();
    	for(String str : wordDict) {
    		words.add(str);
    	}
        boolean isPossible = false;
        int lastEndIndex = 0;
        int endIndex = 0;
        int startIndex = 0;
        StringBuilder word = new StringBuilder("");
            while(endIndex < s.length()) {
            	word.append(s.charAt(endIndex));
            	if(words.contains(word.toString())) {
            		lastEndIndex = endIndex;
            		startIndex = endIndex + 1;
            		if(endIndex == s.length() - 1) {
            			isPossible = true;
            		} else {
            			word = new StringBuilder("");
            		}
            	}
            	endIndex++;
            }
        return isPossible;
    }

    Set<String> wordDictSet;
    public boolean wordBreak(String s, List<String> wordDict) {
    	wordDictSet = new HashSet<>(wordDict);
    	long start = System.nanoTime();
    	Boolean memo[] = new Boolean[s.length()];
        boolean isPossible = wordBreakRecur(s, 0, memo);
        long end = System.nanoTime();
        long duration = end-start;
        System.out.println("Time :: " + duration);
        return isPossible;
    }

    private boolean wordBreakRecur(String s, int start, Boolean []memo) {
    	if(start == s.length()) {
    		return true;
    	}
    	if(memo[start] != null) {
    		return memo[start];
    	}
        for(int end = start + 1;end <= s.length(); end++) {
        	if(wordDictSet.contains(s.substring(start, end)) && wordBreakRecur(s, end, memo)) {
        		memo[start] = true;
        		return true;
        	}
        }
        memo[start] = false;
        return false;
    }
    
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSetl = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
            	String subStr = s.substring(j,i);
            	System.out.println(s.substring(0,j) + " " + s.substring(j, i));
                if (dp[j] && wordDictSetl.contains(subStr)) {
                	System.out.println("match " + s.substring(0,j) + " " + s.substring(j, i));
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

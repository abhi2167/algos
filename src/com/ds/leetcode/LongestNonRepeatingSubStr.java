package com.ds.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestNonRepeatingSubStr {
	
    public static int lengthOfLongestSubstring(String s) {
    	List<String> subStrs = new ArrayList<>();
    	String temp = "";
    	String maxSubStr = "";
    	for(int i=0; i < s.length(); i++) {
    		temp = String.valueOf(s.charAt(i));
    		for(int j=i; j < s.length(); j++) {
    			if(s.charAt(i) != s.charAt(j)) {
    				if(temp.indexOf(s.charAt(j)) == -1) {
    					temp += String.valueOf(s.charAt(j));
    				} else {
    					maxSubStr = temp.length() > maxSubStr.length() ? temp : maxSubStr;
    					break;
    				}
    				
    			} else {
    				maxSubStr = temp.length() > maxSubStr.length() ? temp : maxSubStr;
					break;
    			}
    		}
    	}
        return maxSubStr.length();
    }
    
    public static void main(String[] args) {
    	
    	int[] chars = new int[128];
    	chars['a'] = 2;
    	chars['b'] = 3;
    	System.out.println("Result :: " + lengthOfLongestSubstringS3("ABCCBDEBB"));
    	System.out.println("Result :: " + lengthOfLongestSubstringS2("ABCCBDEBB"));
    	System.out.println("Result :: " + lengthOfLongestSubstringS1("ABCCBDEBB"));
    }
    
    public static int lengthOfLongestSubstringS1(String s) {
    	int res = 0;
    	for(int i=0; i < s.length(); i++) {
    		for(int j=i; j < s.length(); j++) {
    			if(allUnique(s, i,j)) {
    				res = Math.max(res, j - i +1);
    			}
    		}
    	}
    	return res;
    }

    public static boolean allUnique(String s, int start, int end) {
    	int []chars = new int[128];
    	while(start <= end) {
    		char ch = s.charAt(start);
    		chars[ch]++;
    		if(chars[ch] > 1) {
    			return false;
    		}
    		start++;
    	}
    	return true;
    }
    

    public static int lengthOfLongestSubstringS2(String s) {
    	int res = 0;
    	int []chars = new int[128];
    	int left = 0, right =0;
    	while(right < s.length()) {
    		char ch = s.charAt(right);
    		chars[ch]++;
    		while(chars[ch] > 1) {
    			System.out.println("left " + left + " right: "+ right);
    			char lch = s.charAt(left);
    			chars[lch]--;
    			left++;
    		}
    		System.out.println("left " + left + " right: "+ right);
    		res = Math.max(res, right-left+1);
    		right++;
    	}
    	return res;
    }
    
    public static int lengthOfLongestSubstringS3(String s) {
    	int res = 0;
    	Map<Character,Integer> charMap = new HashMap<>();
    	for(int i=0,j=0; j < s.length();j++) {
    		char ch = s.charAt(j);
    		if(charMap.containsKey(ch)) {
    			i = Math.max(charMap.get(ch), i);
    		}
    		res = Math.max(res, j-i+1);
    		charMap.put(ch, j+1);
    		//System.out.println("left : " + i + " right: "+ j);
    	}
    	return res;
    }
}

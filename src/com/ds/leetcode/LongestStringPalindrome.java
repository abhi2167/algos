package com.ds.leetcode;

import java.util.HashSet;

/**
 * 
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

 *
 */
public class LongestStringPalindrome {
	
    public static String longestPalindrome(String s) {
    	String maxPalindrome = "";
    	for(int i=0;i < s.length(); i++) {
    		for(int j=i; j < s.length(); j++) {
    			String subStr = s.substring(i, j+1);
    			//System.out.println(subStr);
    			if(isPalindrome(subStr)) {
    				maxPalindrome = subStr.length() > maxPalindrome.length() ? subStr : maxPalindrome;
    			}
    		}
    	}
    	System.out.println("Counter : " + counter);
        return maxPalindrome;
    }
    
    public static String longestPalindrome2(String s) {
    	counter = 0;
    	String maxPalindrome = "";
    	HashSet<String> palindromes = new HashSet<>();
    	for(int i=0;i < s.length(); i++) {
    		for(int j=i; j < s.length(); j++) {
    			String subStr = s.substring(i, j+1);
    			if((palindromes.contains(subStr)) || isPalindrome(subStr)) {
    				maxPalindrome = subStr.length() > maxPalindrome.length() ? subStr : maxPalindrome;
    				palindromes.add(subStr);
    			}
    		}
    	}
    	System.out.println("Counter : " + counter);
        return maxPalindrome;
    }
    public static int counter = 0;
    private static boolean isPalindrome(String s) {
    	counter++;
    	int left = 0;
    	int right = s.length() -1;
    	while(left < right)  {
    		if(s.charAt(left) == s.charAt(right)) {
    			left++;
    			right--;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    public static String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    
    
    public static void main(String[] args) {
    	long start = System.currentTimeMillis();
    	System.out.println("Result :: " + longestPalindrome("mwwfjysbkebpdjyabcfkgprtxpwvhglddhmvaprcvrnuxifcrjpdgnktvmggmguiiquibmtviwjsqwtchkqgxqwljouunurcdtoeygdqmijdympcamawnlzsxucbpqtuwkjfqnzvvvigifyvymfhtppqamlgjozvebygkxawcbwtouaankxsjrteeijpuzbsfsjwxejtfrancoekxgfyangvzjkdskhssdjvkvdskjtiybqgsmpxmghvvicmjxqtxdowkjhmlnfcpbtwvtmjhnzntxyfxyinmqzivxkwigkondghzmbioelmepgfttczskvqfejfiibxjcuyevvpawybcvvxtxycrfbcnpvkzryrqujqaqhoagdmofgdcbhvlwgwmsmhomknbanvntspvvhvccedzzngdywuccxrnzbtchisdwsrfdqpcwknwqvalczznilujdrlevncdsyuhnpmheukottewtkuzhookcsvctsqwwdvfjxifpfsqxpmpwospndozcdbfhselfdltmpujlnhfzjcgnbgprvopxklmlgrlbldzpnkhvhkybpgtzipzotrgzkdrqntnuaqyaplcybqyvidwcfcuxinchretgvfaepmgilbrtxgqoddzyjmmupkjqcypdpfhpkhitfegickfszermqhkwmffdizeoprmnlzbjcwfnqyvmhtdekmfhqwaftlyydirjnojbrieutjhymfpflsfemkqsoewbojwluqdckmzixwxufrdpqnwvwpbavosnvjqxqbosctttxvsbmqpnolfmapywtpfaotzmyjwnd"));
    	//System.out.println("Result :: " + longestPalindrome("ABABA"));
    	long end = System.currentTimeMillis();
    	System.out.println("Time for execution == "+ (end-start));
    	
    	System.out.println("===============================");
    	
    	long start1 = System.currentTimeMillis();
    	System.out.println("Result :: " + longestPalindrome3("mwwfjysbkebpdjyabcfkgprtxpwvhglddhmvaprcvrnuxifcrjpdgnktvmggmguiiquibmtviwjsqwtchkqgxqwljouunurcdtoeygdqmijdympcamawnlzsxucbpqtuwkjfqnzvvvigifyvymfhtppqamlgjozvebygkxawcbwtouaankxsjrteeijpuzbsfsjwxejtfrancoekxgfyangvzjkdskhssdjvkvdskjtiybqgsmpxmghvvicmjxqtxdowkjhmlnfcpbtwvtmjhnzntxyfxyinmqzivxkwigkondghzmbioelmepgfttczskvqfejfiibxjcuyevvpawybcvvxtxycrfbcnpvkzryrqujqaqhoagdmofgdcbhvlwgwmsmhomknbanvntspvvhvccedzzngdywuccxrnzbtchisdwsrfdqpcwknwqvalczznilujdrlevncdsyuhnpmheukottewtkuzhookcsvctsqwwdvfjxifpfsqxpmpwospndozcdbfhselfdltmpujlnhfzjcgnbgprvopxklmlgrlbldzpnkhvhkybpgtzipzotrgzkdrqntnuaqyaplcybqyvidwcfcuxinchretgvfaepmgilbrtxgqoddzyjmmupkjqcypdpfhpkhitfegickfszermqhkwmffdizeoprmnlzbjcwfnqyvmhtdekmfhqwaftlyydirjnojbrieutjhymfpflsfemkqsoewbojwluqdckmzixwxufrdpqnwvwpbavosnvjqxqbosctttxvsbmqpnolfmapywtpfaotzmyjwnd"));
    	//System.out.println("Result :: " + longestPalindrome2("ABABA"));
    	long end1 = System.currentTimeMillis();
    	System.out.println("Time for execution == "+ (end1-start1));
    }

}

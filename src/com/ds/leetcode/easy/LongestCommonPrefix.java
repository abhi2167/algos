package com.ds.leetcode.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix p = new LongestCommonPrefix();
		String[] strs = {"flower", "flow", "flight"};
		
		System.out.println("Result is :: " + p.longestCommonPrefix_vertical(strs));
		System.out.println("Result is :: " + p.longestCommonPrefix_horizontal(strs));
		System.out.println("Result is :: " + p.longestCommonPrefix_DivideAndConquer(strs,0,strs.length-1));
		
	}
	
	public String longestCommonPrefix_vertical(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		if(strs.length == 1) {
			return strs[0];
		}
		int smallestStrIndex = 0;
		int minLength = Integer.MAX_VALUE;
		StringBuilder prefix = new StringBuilder("");
		for(int i=0; i < strs.length; i++) {
			if(strs[i].length() < minLength) {
				minLength = strs[i].length();
				smallestStrIndex = i;
			}
		}
		System.out.println("min length string "+ minLength + " index is " + smallestStrIndex);
		for(int i=0; i < minLength; i++) {
			char ch = strs[smallestStrIndex].charAt(i);
			for(int j=0; j < strs.length; j++) {
				if(ch != strs[j].charAt(i)) {
					return prefix.toString();
				}
			}
			prefix.append(ch);
		}
        return prefix.toString();
    }
	
	public String longestCommonPrefix_horizontal(String[] strs) {
		if(strs.length == 0)
			return "";
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) return "";
			}
		}
		return prefix;
    }
	
	public String longestCommonPrefix_vertical2(String[] strs) {
		if(strs.length == 0)
			return "";
		for(int i=0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(strs[j].charAt(i) != ch || strs[j].length() == i) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
    }
	
	public String longestCommonPrefix_DivideAndConquer(String[] strs, int left, int right) {
		if(left == right) 
			return strs[left];
		else {
			int mid = (left+right)/2;
			String lcpLeft = longestCommonPrefix_DivideAndConquer(strs, 0, mid);
			String lcpRight = longestCommonPrefix_DivideAndConquer(strs,mid+1, right);
			return commonPrefix(lcpLeft, lcpRight);
		}
    }
	
	private String commonPrefix(String s1, String s2) {
		String prefix = s1;
//		while(s2.indexOf(prefix) != 0) {
//			prefix = prefix.substring(0, prefix.length()-1);
//			if(prefix.isEmpty()) return "";
//		}
		return prefix;
	}
}

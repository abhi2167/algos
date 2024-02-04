package com.ds.course.algos.lcs.palindrome.substring;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		LongestPalindromeSubString l = new LongestPalindromeSubString();
		String s = "ABCCBUA";
		System.out.println("Result :: "+ l.findPalindromeSubstring(s, 0, s.length()-1));

	}

	private int findPalindromeSubstring(String s, int start, int end) {
		if(start > end)
			return 0;
		if(start == end)
			return 1;
		int c1 = 0;
		if(s.charAt(start) == s.charAt(end)) {
			int remainingLength = end - start - 1;
			if(findPalindromeSubstring(s, start+1, end-1) == remainingLength) {
				c1 = 2 + remainingLength;
			}
		}
		int c2 = findPalindromeSubstring(s, start, end-1);
		int c3 = findPalindromeSubstring(s, start+1, end);
		return Math.max(c1, Math.max(c2, c3));
	}
}

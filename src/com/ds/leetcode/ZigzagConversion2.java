package com.ds.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
 *
 */
public class ZigzagConversion2 {

	public static void main(String[] args) {
		ZigzagConversion2 z = new ZigzagConversion2();
		System.out.println("Result ===" + z.convert("PAYPALISHIRING", 4));
	}

	public String convert(String s, int numRows) {
		StringBuilder result = new StringBuilder();
		int currentRow = 0;
		int n = s.length();

		int charsInSection = 2 * (numRows - 1);
		while(currentRow < numRows) {
			int nextIndex = currentRow;
			while(nextIndex < n) {
				result.append(s.charAt(nextIndex));
				if(currentRow != 0 && currentRow != numRows-1) {
					int charsInBetween = charsInSection - (2 * currentRow);
					int secondIndex = nextIndex + charsInBetween;
					if(secondIndex < n) {
						result.append(s.charAt(secondIndex));
					}
				}
				nextIndex += charsInSection;

			}
			currentRow++;
		}
		return result.toString();
	}
}
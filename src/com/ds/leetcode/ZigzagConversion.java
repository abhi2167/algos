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
public class ZigzagConversion {
	
	public static void main(String []args) {
		ZigzagConversion z = new ZigzagConversion();
		System.out.println("Result ===" + z.convert("PAYPALISHIRING", 4));
		System.out.println("Result ===" + z.convert2("PAYPALISHIRING", 4));
		System.out.println("Result ===" + z.convert3("PAYPALISHIRING", 4));
		System.out.println("Result ===" + z.convert3("PAYPALISHIRING", 4));
	}

	public String convert_high_efficiency(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		StringBuilder[] arr = new StringBuilder[numRows];
		for(int i=0; i < s.length(); i++) {
			arr[i] = new StringBuilder();
		}
		int i = 0;
		while ( i < numRows) {
			for(int ind = 0; ind < numRows && i < n; i++) {
				arr[ind].append(s.charAt(i++));
			}
			for(int ind = numRows-2; ind > 0 && i < n; ind--) {
				arr[ind].append(s.charAt(i++));
			}
		}
		for(StringBuilder sbi : arr) {
			sb.append(sbi);
		}
		return sb.toString();
	}

	public String convert3(String s, int numRows) {
		if (s == null || s.length() <= 2 || numRows == 1) {
			return s;
		}
		char[][] characters = new char[numRows][20];
		int row = 0, col= 0;
		boolean goingUp = false;
		for(int i=0; i < s.length(); i++) {
			char ch = s.charAt(i);
			characters[row][col] = ch;
			if (goingUp) {
				row--;
				col++;

			} else {
				row++;
			}

			if(row >= numRows) {
				row = numRows - 2;
				col++;
				goingUp = true;
			} else if(row < 0) {
				goingUp = false;
				row+=2;
				col--;
			}
		}

		return printArray(characters);

	}

	private static String printArray(char[][] dp) {
		StringBuilder sb = new StringBuilder();
		System.out.println("\n=========================================");
		for (int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				if(dp[i][j] != 0) {
					sb.append(dp[i][j]);
				}

			}
		}
		return sb.toString();
	}

    public String convert(String s, int numRows) {
    	if(s == null || numRows < 2) {
    		return s;
    	}
    	StringBuilder result = new StringBuilder("");
    	boolean forward = true;
    	int row = 0, col=0;
    	char [][] converted = new char[numRows][10];
    	for(int i=0; i<s.length(); i++) {
    		converted[row][col]=s.charAt(i);
    		if(forward) {
    			row++;
    		} else {
    			row--;
    			col++;
    		}
    		if(row == numRows) {
    			row-=2;
    			col++;
    			forward = false;
    		} else if(row < 0) {
    			row+=2;
    			col--;
    			forward = true;
    		}
    	}
    	for(int i=0; i<converted.length;i++) {
    		for(int j=0; j<converted[i].length;j++) {
    			if(converted[i][j] != 0)
    				result.append(converted[i][j]);
    		}
    	}
        return result.toString();
    }

    public String convert2(String s, int numRows) {
    	if(s == null || numRows < 2) {
    		return s;
    	}
    	StringBuilder result = new StringBuilder("");
    	List<StringBuilder> rows = new ArrayList<>();
    	for(int i=0; i < Math.min(s.length(), numRows);i++) {
    		rows.add(new StringBuilder());
    	}
    	int currentRow =0;
    	boolean goingDown = false;
    	for(char ch : s.toCharArray()) {
    		rows.get(currentRow).append(ch);
    		if(currentRow == 0 || currentRow == numRows-1) {
    			goingDown = !goingDown;
    		}
    		currentRow += goingDown ? 1 : -1; 
    	}
    	for(StringBuilder row : rows) {
    		result.append(row);
    	}
        return result.toString();
    }
}

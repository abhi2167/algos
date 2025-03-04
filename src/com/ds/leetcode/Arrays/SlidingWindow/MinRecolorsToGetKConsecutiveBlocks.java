package com.ds.leetcode.Arrays.SlidingWindow;

public class MinRecolorsToGetKConsecutiveBlocks {

    public static void main(String[] args) {
        MinRecolorsToGetKConsecutiveBlocks o = new MinRecolorsToGetKConsecutiveBlocks();
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println("Minimum number of operations to perform to get k consecutive blocks of W or B " + o.minimumRecolors(blocks, k));
        System.out.println("Minimum number of operations to perform to get k consecutive blocks of W or B " + o.minimumRecolors_using_sliding(blocks, k));
    }


    public int minimumRecolors_using_sliding(String blocks, int k) {

        int minOp = Integer.MAX_VALUE;
        int countW = 0;
        for(int i = 0; i < k; i++) {
            countW += blocks.charAt(i) == 'W' ? 1 : 0;
        }
        minOp = countW;
        for(int i = k; i < blocks.length(); i++) {
            countW -= blocks.charAt(i-k) == 'W' ? 1 : 0;
            countW += blocks.charAt(i) == 'W' ? 1 : 0;
            minOp = Math.min(minOp, countW);
        }
        return minOp;
    }

    public int minimumRecolors(String blocks, int k) {

        int minOp = Integer.MAX_VALUE;

        for(int i = 0; i <= blocks.length() - k; i++) {
            String subStr = blocks.substring(i, i+k);
            int countW = 0;

            for(int j = 0; j < subStr.length(); j++) {
                countW += subStr.charAt(j) == 'W' ? 1 : 0;
            }
            minOp = Math.min(minOp, countW);
        }
        return minOp;
    }
}

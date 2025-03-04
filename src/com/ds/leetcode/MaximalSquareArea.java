package com.ds.leetcode;

import java.util.Arrays;

public class MaximalSquareArea {

    public static void main(String[] args) {
        MaximalSquareArea m = new MaximalSquareArea();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(" Maximum area == " + m.maximalSquare(matrix));
        System.out.println(" Maximum area == " + m.maximalSquare_bu(matrix));
    }


    public int maximalSquare_bu(char[][] matrix) {
        int rows = matrix.length + 1;
        int cols = (matrix.length > 0 ? matrix[0].length : 0) + 1;
        int[][] dp = new int[rows][cols];
        int maxSqLen = 0;
        for(int row = 1; row < rows; row++) {
            for(int col= 1; col < cols; col++) {
                if(matrix[row-1][col-1] == '1') {
                    dp[row][col] = 1  + Math.min(dp[row-1][col-1], Math.min(dp[row-1][col], dp[row][col-1]));
                }
                maxSqLen = Math.max(maxSqLen, dp[row][col]);
            }
        }
        return maxSqLen * maxSqLen;
    }

    public int maximalSquare(char[][] matrix) {
        int maxSqLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    boolean isSquare = true;
                    int currentArea = 1;
                    while(currentArea + i < matrix.length && currentArea + j < matrix[i].length && isSquare) {
                        for(int k=j; k <= currentArea+j; k++) {
                            if(matrix[i+currentArea][k] != '1') {
                                isSquare = false;
                                break;
                            }
                        }
                        for(int k=i; k <= currentArea+i; k++) {
                            if(matrix[k][j+currentArea] != '1') {
                                isSquare = false;
                                break;
                            }
                        }
                        if(isSquare) {
                            currentArea++;
                        }
                    }
                    maxSqLen = Math.max(maxSqLen, currentArea);
                    // while all cols are == 1

                }
                // is square (i+1, j+1)
            }
        }
        return maxSqLen * maxSqLen;
    }
}

package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class RotateTheBox {

    public static void main(String[] args) {
        RotateTheBox o = new RotateTheBox();
        char[][] box = {{'#','#','*','.','*','.'},
                        {'#','#','#','*','.','.'},
                        {'#','#','#','.','#','.'}};
        printBox(box);
        char[][] rotatedBox = o.rotateTheBox(box);
        System.out.println("result of rotating the box 90 clockwise ");
        printBox(rotatedBox);
        char[][] rotatedBox2 = o.rotateTheBox_eff(box);
        System.out.println("result of rotating the box 90 clockwise eff");
        printBox(rotatedBox2);
    }

    private static void printBox(char[][] rotatedBox) {
        System.out.print("\n");
        for(int row = 0; row < rotatedBox.length; row++) {
            System.out.println(Arrays.toString(rotatedBox[row]));
        }
    }

    public char[][] rotateTheBox_eff(char[][] boxGrid) {
        char[][] result = new char[boxGrid[0].length][boxGrid.length];
        for(int row = 0; row < result.length; row++) {
            for(int col = 0; col < result[0].length; col++) {
                result[row][col] = boxGrid[col][row];
            }
        }
        for(int row = 0; row < result.length; row++) {
            reverseRow(result[row]);
        }
        for(int col = 0; col < result[0].length; col++) {
            int prevRowWithEmpty = result.length-1;
            for(int row = result.length-1; row >= 0; row--) {
                if(result[row][col] == '#') {
                    result[row][col] = '.';
                    result[prevRowWithEmpty][col] = '#';
                    prevRowWithEmpty--;
                }
                if(result[row][col] == '*') {
                    prevRowWithEmpty = row-1;
                }
            }
        }
        return result;
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] result = new char[boxGrid[0].length][boxGrid.length];
        for(int row = 0; row < result.length; row++) {
            for(int col = 0; col < result[0].length; col++) {
                result[row][col] = boxGrid[col][row];
            }
        }
        for(int row = 0; row < result.length; row++) {
            reverseRow(result[row]);
        }
        for(int col = 0; col < result[0].length; col++) {
            for(int row = result.length-1; row >= 0; row--) {
                if(result[row][col] == '.') {
                    int nextRowWithStone = -1;
                    for(int k = row-1; k >=0; k--) {
                        if(result[k][col] == '*') {
                            break;
                        } else if(result[k][col] == '#') {
                            nextRowWithStone = k;
                            break;
                        }
                    }
                    if(nextRowWithStone != -1) {
                        result[nextRowWithStone][col] = '.';
                        result[row][col] = '#';
                    }
                }
            }
        }
        return result;
    }

    private void reverseRow(char[] row) {
        int left = 0;
        int right = row.length-1;
        while(left < right) {
            char temp = row[right];
            row[right] = row[left];
            row[left] = temp;
            left++;
            right--;
        }
    }
}

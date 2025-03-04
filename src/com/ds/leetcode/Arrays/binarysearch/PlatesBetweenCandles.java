package com.ds.leetcode.Arrays.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class PlatesBetweenCandles {

    public static void main(String[] args) {
        PlatesBetweenCandles o = new PlatesBetweenCandles();
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println("Number of plates between candles = " + Arrays.toString(o.platesBetweenCandles(s, queries)));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int result[] = new int[queries.length];
        List<Integer> candlesCount = new ArrayList<>();
        List<Integer> candles = new ArrayList<>();
        if(s.charAt(0) == '|') {
            candlesCount.add(1);
            candles.add(0);
        } else {
            candlesCount.add(0);
        }
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                candles.add(i);
                candlesCount.add(1+candlesCount.get(i-1));
            } else {
                candlesCount.add(candlesCount.get(i-1));
            }
        }
        int resIndex = 0;
        for(int[] query : queries) {
            int leftBoundary = query[0];
            int rightBoundary = query[1];
            int left = 0;
            int right = candles.size()-1;
            int mid;
            int leftPos = -1;
            int rightPos = -1;
            while(left <= right) {
                mid = left + (right-left)/2;
                if(candles.get(mid) >= leftBoundary) {
                    right = mid - 1;
                    leftPos = candles.get(mid);
                } else {
                    left = mid + 1;
                }
            }
            left = 0;
            right = candles.size() - 1;
            while(left <= right) {
                mid = left + (right-left)/2;
                if(candles.get(mid) <= rightBoundary) {
                    rightPos = candles.get(mid);
                    left = mid+1;
                } else {
                    right = mid - 1;
                }
            }
            // count plates between left and right pos
            if(leftPos != -1 && rightPos != -1 && rightPos > leftPos) {
                result[resIndex] = (rightPos - leftPos) - (candlesCount.get(rightPos) - candlesCount.get(leftPos));
            } else {
                result[resIndex] = 0;
            }
            resIndex++;

        }
        return result;
    }
}

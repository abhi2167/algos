package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class FindHIndex {

    public static void main(String[] args) {
        FindHIndex f = new FindHIndex();
        //int[] citations = {11,15,17};
        //int[] citations = {3,0,6,1,5};
        int[] citations = {1,2,3,3,5,9,10};
        System.out.println("H index = " + f.hIndex_btf(citations));
        System.out.println("H index = " + f.hIndex_n(citations));

    }


    public int hIndex_n(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int maxIndex = 0;
        for(int i=0; i < n; i++) {
            if(citations[n-i-1] > i) {
                maxIndex++;
            }
        }

        return maxIndex;
    }

    public int hIndex_btf(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int n = citations.length;
        int maxIndex = 0;
        for(int hidx = n; hidx >=0; hidx--) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(citations[i] >= hidx) {
                    count++;
                }
                if(count == hidx) {
                    maxIndex = Math.max(maxIndex,count);
                }
            }
        }

        return maxIndex;
    }
}

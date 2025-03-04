package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class FindDuplicateZeros {

    public static void main(String[] args) {
        FindDuplicateZeros o = new FindDuplicateZeros();
        int[] arr = {0,1,7,6,0,2,0,7};
        o.duplicateZeros(arr);
        System.out.print("Array after duplicating zeros once  = " + Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        int k = 0;
        int n = arr.length;
        int lastEl = n-1;
        for(int i = 0; i < lastEl-k; i++) {
            if(arr[i] == 0) {
                if(i == lastEl-k) {
                    arr[lastEl] = 0;
                    lastEl--;
                    break;
                }
                k++;
            }
        }
        System.out.println(k);
        for(int i = lastEl-k; i >=0; i--) {
            if(arr[i] != 0) {
                arr[i+k] = arr[i];
            } else {
                arr[i+k] = arr[i];
                k--;
                arr[i+k] = arr[i];
            }
        }
    }
}

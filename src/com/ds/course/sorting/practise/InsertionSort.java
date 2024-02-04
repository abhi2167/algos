package com.ds.course.sorting.practise;

import java.util.Arrays;

public class InsertionSort {

    private static int arr[] = {30, 40 , 10, 20, 60, 15};

    public static void main (String[] args) {
        System.out.println("Before Sort :: " + Arrays.toString(arr));
        System.out.println("After sort :: " + Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {
        for(int i=1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while ( j > 0 && arr[j-1] > temp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }
}

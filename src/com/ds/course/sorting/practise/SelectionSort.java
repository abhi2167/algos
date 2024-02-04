package com.ds.course.sorting.practise;

import java.util.Arrays;

public class SelectionSort {
    private static int arr[] = {30, 40 , 10, 20, 60, 15};


    public static void main (String[] args) {
        System.out.println("Before Sort :: " + Arrays.toString(arr));
        System.out.println("After sort :: " + Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {
        for(int i=0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for(int j=i+1; j < arr.length; j++) {
                if(arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            if(minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
        return arr;
    }
}

package com.ds.course.sorting.practise;

import java.util.Arrays;

public class BubbleSort {

    private static int arr[] = {30, 40 , 10, 20, 60, 15};

    public static void main (String[] args) {
        System.out.println("Before Sort :: " + Arrays.toString(arr));
        BubbleSort b = new BubbleSort();
        System.out.println("After sort :: " + Arrays.toString(b.sort(arr)));
    }

    private int[] sort(int[] arr) {
        for(int i=0; i < arr.length - 1; i++) {
            for(int j=0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}

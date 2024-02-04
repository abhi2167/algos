package com.ds.course.sorting.practise;

import java.util.Arrays;

public class QuickSort {

    private static int arr[] = {30, 20 , 45, 10, 80, 50, 15, 40};


    public static void main (String[] args) {
        System.out.println("Before Sort :: " + Arrays.toString(arr));
        System.out.println("After sort :: " + Arrays.toString(sort(arr)));
    }






    private static int[] sort(int[] arr) {
        quick_sort(arr, 0, arr.length-1);
        return arr;
    }

    private static void quick_sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = arr[end];
            int j = start;
            int i = j - 1;
            while(j <= end) {
                if(arr[j] <= pivot) {
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
            quick_sort(arr, 0, i-1);
            quick_sort(arr, i+1, end);
        }
    }
}

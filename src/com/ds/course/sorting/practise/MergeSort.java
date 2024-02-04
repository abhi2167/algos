package com.ds.course.sorting.practise;

import java.util.Arrays;

public class MergeSort {

    private static int arr[] = {30, 20 , 40, 10, 80, 50, 15, 9};


    public static void main (String[] args) {
        System.out.println("Before Sort :: " + Arrays.toString(arr));
        System.out.println("After sort :: " + Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {

        msort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void msort(int[] arr, int start, int end) {
        System.out.println(" start " + start + " end " + end );
        if(start < end) {
            int mid = (start + end) / 2;
            msort(arr, start, mid);
            msort ( arr, mid+1, end);
            mergeArrays(arr, start, mid, end);
        }
    }

    private static int[] mergeArrays(int[] arr, int start, int mid, int end) {
        System.out.println(" start " + start + " mid " + mid + " end " + end);
        int left[] = new int[mid-start+1];
        int right[] = new int[end-mid];
        int i = 0 , j = 0, k = start;

        for(int p=0; p < left.length; p++) {
            left[p] = arr[p+start];
        }
        System.out.println(Arrays.toString(left));

        for(int q=0; q < right.length; q++) {
            right[q] = arr[q+mid+1];
        }
        System.out.println(Arrays.toString(right));

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        //System.out.println(" i " + i + " j " + j + " k " + k);
        while(i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}

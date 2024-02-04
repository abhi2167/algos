package com.ds.course.sorting.practise;

import java.util.Arrays;

public class HeapSort {

    private static int arr[] = {30, 20 , 45, 10, 80, 50, 15, 40};


    public static void main (String[] args) {
        HeapSort h = new HeapSort();
        System.out.println("Before Sort :: " + Arrays.toString(arr));
        System.out.println("After sort :: " + Arrays.toString(h.sort(arr)));
    }

    private int[] sort(int[] arr) {
        //quick_sort(arr, 0, arr.length-1);
        BinaryHeap heap = new BinaryHeap(arr.length);
        for(int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.extract();
        }
        return arr;
    }

}

package com.ds.course.algos;

import java.util.Arrays;

public class BinarySearch {

    private static int arr[] = {10, 20 , 30, 40, 50, 60, 75, 90};


    public static void main (String[] args) {
        System.out.println("Before Search :: " + Arrays.toString(arr));
        System.out.println("Search Result:: " + search(arr, 75));
    }

    private static boolean search(int [] arr, int target) {
        return binarySearch(arr, 0, arr.length-1, target);
    }

    private static boolean binarySearch(int[] arr, int left, int right, int target) {
        int mid = (left + right)/2;
         if(target < arr[mid]) {
            return binarySearch(arr, left, mid-1, target);
        } else if (target > arr[mid]){
            return binarySearch(arr, mid+1, right, target);
        } else {
             return arr[mid] == target;
         }
    }
}

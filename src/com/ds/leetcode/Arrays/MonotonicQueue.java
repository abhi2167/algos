package com.ds.leetcode.Arrays;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MonotonicQueue {

    static Deque<Integer>
    increasing_monotonic_queue(int arr[], int n)
    {

        Deque<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {

            // If recently added element is
            // greater current element
            while (!q.isEmpty() && q.getLast() < arr[i]) {

                q.removeLast();
            }

            q.addLast(arr[i]);
        }

        return q;
    }

    // Driver code
    public static void main(String[] args)
    {

        int arr[] = { 10,9,2,5,3,7, 101, 1,2,3, 102,98, 97, 96 };
        int n = arr.length;

        // Function call
        Deque<Integer> q
                = increasing_monotonic_queue(arr, n);

        Iterator it = q.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

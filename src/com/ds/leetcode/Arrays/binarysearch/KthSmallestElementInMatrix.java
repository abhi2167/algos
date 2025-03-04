package com.ds.leetcode.Arrays.binarysearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInMatrix {

    public static void main(String[] args) {
        KthSmallestElementInMatrix o = new KthSmallestElementInMatrix();
        int[][] sortedMatrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println("kth smallest element in sorted matrix using priority queue = " + o.kthSmallest_pq(sortedMatrix, k));
        System.out.println("kth smallest element in sorted matrix using binary search = " + o.kthSmallest_bs(sortedMatrix, k));
    }

    public int kthSmallest_pq(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<HeapNode> queue = new PriorityQueue<>(Math.min(n, k), new HeapNodeComparator());
        for(int row = 0; row < Math.min(n, k); row++) {
            queue.offer(new HeapNode(matrix[row][0], row, 0));
        }
        HeapNode node = queue.peek();
        while(k > 0) {
            node = queue.poll();
            int row = node.row;
            int col = node.col;
            if(col < n-1) {
                queue.offer(new HeapNode(matrix[row][col+1], row, col+1));
            }
            k--;
        }
        return node.value;
    }

    public int kthSmallest_bs(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        int mid;

        while(left < right) {
            mid = left + (right-left)/2;
            int[] smallLargePair = {left, right};
            int count = countElementsOnLeft(matrix, mid, smallLargePair);
            if(count == k) {
                return smallLargePair[0];
            } else if(count > k) {
                right = smallLargePair[0];
            } else {
                left = smallLargePair[1];
            }
        }

        return left;
    }

    private int countElementsOnLeft(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int row = matrix.length-1;
        int col = 0;
        while(row >=0 && col < matrix.length){
            if(matrix[row][col] > mid) {
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                col++;
                count += row+1;
            }
        }
        return count;
    }
}

class HeapNodeComparator implements Comparator<HeapNode> {
    @Override
    public int compare(HeapNode o1, HeapNode o2) {
        return o1.value - o2.value;
    }
}
class HeapNode {
    int value;
    int row;
    int col;

    public HeapNode(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
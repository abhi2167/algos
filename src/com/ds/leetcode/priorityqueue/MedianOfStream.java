package com.ds.leetcode.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

    private PriorityQueue<Double> minHeap = new PriorityQueue<>();
    private PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        MedianOfStream o = new MedianOfStream();
        // 1 5 3 7 2 8 6 4
        o.addNum(1);
        System.out.println("median of stream is " + o.getMedian());
        o.addNum(5);
        System.out.println("median of stream is " + o.getMedian());
        o.addNum(3);
        System.out.println("median of stream is " + o.getMedian());
        o.addNum(7);
        System.out.println("median of stream is " + o.getMedian());
        o.addNum(2);
        System.out.println("median of stream is " + o.getMedian());
        o.addNum(8);
        System.out.println("median of stream is " + o.getMedian());
        o.addNum(6);
        System.out.println("median of stream is " + o.getMedian());
        o.addNum(4);
        System.out.println("median of stream is " + o.getMedian());
    }

    public void addNum(int num) {
        // WRITE YOUR BRILLIANT CODE HERE
        if(minHeap.size() == 0 || num < minHeap.peek()) {
            maxHeap.offer((double) num);
        } else {
            minHeap.offer((double) num);
        }
        rebalance();
    }

    private void rebalance() {
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else if(maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double getMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek())/2;
        } else {
            return maxHeap.peek();
        }
    }
}

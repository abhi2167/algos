package com.ds.course.binaryheap.practise;

public class NBinaryHeap {

    private int[] heap;
    private int sizeOfHeap;

    NBinaryHeap() {
        heap = new int[20];
        this.sizeOfHeap = 0;
    }

    NBinaryHeap(int size) {
        heap = new int[size+1];
        this.sizeOfHeap = 0;
    }

    public void add(int val) {
        if(heap[1] == 0) {
            heap[1] = val;
        } else if(sizeOfHeap >= heap.length - 1) {
            System.out.println("max capacity reached");
        } else {
            heap[sizeOfHeap+1] = val;
            sizeOfHeap++;
            heapifyBottomToTop(sizeOfHeap);
        }

    }

    public int extractHead() {
        int head = heap[1];
        heap[1] = heap[sizeOfHeap];
        heap[sizeOfHeap] = 0;
        sizeOfHeap--;
        heapifyTopToBottom(1);
        return head;
    }

    private void heapifyTopToBottom(int currentIndex) {
        int left = 2 * currentIndex;
        int right = 2 * currentIndex + 1;
        if(sizeOfHeap < left) {
            // no children or leaf node
            return;
        } else if(sizeOfHeap == left) {
            // has only left children
            if(heap[currentIndex] > heap[left]) {
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[left];
                heap[left] = temp;
            }
        } else {
            int smallestChildIndex;
            if(heap[left] <= heap[right])
                smallestChildIndex = left;
            else
                smallestChildIndex = right;
            if(heap[currentIndex] > heap[smallestChildIndex]) {
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[smallestChildIndex];
                heap[smallestChildIndex] = temp;
            }
            heapifyTopToBottom(smallestChildIndex);
        }
    }

    private void heapifyBottomToTop(int currentIndex) {
        if(currentIndex <= 1) {
            return;
        }
        int parent = currentIndex/2;
        if(heap[currentIndex] < heap[parent]) {
            int temp = heap[currentIndex];
            heap[currentIndex] = heap[parent];
            heap[parent] = temp;
        }
        heapifyBottomToTop(parent);
    }


}

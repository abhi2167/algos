package com.ds.course.sorting.practise;

public class BinaryHeap {

    private int [] arr;
    private int sizeOfHeap;

    BinaryHeap() {
        sizeOfHeap = 0;
    }

    BinaryHeap(int size) {
        this.arr = new int[size + 1];
        this.sizeOfHeap = 0;
    }

    public void insert(int val) {
        sizeOfHeap++;
        arr[sizeOfHeap] = val;
        heapifyFromBottomToTop(sizeOfHeap);
    }

    private void heapifyFromBottomToTop(int currentIndex) {
        if(currentIndex <= 1) {
            return;
        }
        int parent = currentIndex/2;
        if(arr[currentIndex] < arr[parent]) {
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[parent];
            arr[parent] = temp;
        }
        heapifyFromBottomToTop(parent);
    }

    public int extract() {
        int returnVal = arr[1];
        arr[1] = arr[sizeOfHeap];
        arr[sizeOfHeap] = 0;
        sizeOfHeap--;
        heapifyFromTopToBottom(1);
        return returnVal;
    }

    private void heapifyFromTopToBottom(int parentIndex) {
        int left = parentIndex * 2;
        int right = parentIndex * 2 + 1;
        if(left > sizeOfHeap) {
            return;
        } else if (left == sizeOfHeap) {
            if(arr[left] < arr[parentIndex]) {
                int temp = arr[left];
                arr[left] = arr[parentIndex];
                arr[parentIndex] = temp;
            }
        } else {
            int minIndex = left;
            if(arr[right] < arr[left]) {
                minIndex = right;
            }
            if(arr[minIndex] < arr[parentIndex]) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
            }
            heapifyFromTopToBottom(minIndex);
        }
    }
}

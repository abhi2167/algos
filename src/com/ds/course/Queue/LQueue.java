package com.ds.course.Queue;

public class LQueue {

    private int[] queue;
    int head;
    int tail;

    public LQueue() {
        this.head = -1;
        this.tail = - 1;
        this.queue = new int[5];
    }

    public LQueue(int size) {
        this.head = -1;
        this.tail = -1;
        this.queue = new int[size];
    }

    public void push(int val) {
        if(isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        tail++;
        queue[tail] = val;
        head = head == -1 ? 0 : head;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println(" \n Queue is empty");
            return -1;
        }
        int val = queue[head];
        head++;
        if(head > tail) {
            //reset queue
            head = tail = -1;
        }
        return val;
    }

    public boolean isFull() {
        return tail == queue.length - 1;
    }

    public boolean isEmpty() {
        return head == tail + 1 || head == -1;
    }

    public void traverse() {
        System.out.println();
        int i = head;
        int j = tail;
        while(i <= j) {
            System.out.print(queue[i] + ", ");
            i++;
        }
    }
}

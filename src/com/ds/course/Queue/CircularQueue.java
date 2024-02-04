package com.ds.course.Queue;

public class CircularQueue {
    private int[] queue;
    int head;
    int tail;

    public CircularQueue() {
        this.head = -1;
        this.tail = -1;
        this.queue = new int[5];
    }

    public CircularQueue(int size) {
        this.head = -1;
        this.tail = -1;
        this.queue = new int[size];
    }

    public void enQueue(int val) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(tail + 1 == queue.length || tail == -1) {
            tail = 0;
            queue[tail] = val;
        } else {
            tail++;
            queue[tail] = val;
        }
        if(head == -1) {
            head = 0;
        }
    }

    public int deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = queue[head];
        if(head == tail) {
            head = tail = -1;
        } else if(head + 1 == queue.length) {
            head = 0;
        } else {
            head++;
        }
        return val;
    }


    public void printQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
        }
        System.out.println("\n");
        for(int i = head; i <= tail; i++) {
            System.out.print(queue[i] + "\t");
        }
    }

    public boolean isFull() {
        return (tail == queue.length - 1 && head == 0) || tail + 1 == head;
    }

    public boolean isEmpty() {
        return head == -1;
    }
}

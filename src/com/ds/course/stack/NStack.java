package com.ds.course.stack;

public class NStack {
    private int[] stack;
    int head;

    public NStack() {
        this.stack = new int[10];
        this.head = -1;
    }

    public NStack(int size) {
        this.stack = new int[size];
        this.head = -1;
    }

    public void push(int val) {
        if(isFull()) {
            System.out.println("\n Stack is Full");
            return;
        }
        this.head++;
        this.stack[head] = val;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int val = this.stack[head];
        head--;
        return val;
    }

    public boolean isFull() {
        return this.head == stack.length - 1;
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public void traverse() {
        System.out.println();
        if(isEmpty()) {
            System.out.println("Stack is Empty");
        }
        for(int i = head; i >= 0; i--) {
            System.out.print(this.stack[i] + " ");
        }
    }

}

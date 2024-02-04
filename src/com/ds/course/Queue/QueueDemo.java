package com.ds.course.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        //linearQueueDemo();
        circularQueueDemo();
    }

    private static void circularQueueDemo() {
        CircularQueue q = new CircularQueue(5);
        q.enQueue(5);
        q.enQueue(10);
        q.enQueue(15);
        q.enQueue(20);
        q.enQueue(25);
        q.enQueue(30);
        q.printQueue();
        q.deQueue();
        System.out.println("\n removed 5");
        q.printQueue();
        q.enQueue(30);
        System.out.println("Printing queue");
        q.printQueue();

        System.out.println("\n Dequeuing");
        for(int i = 0; i < 6; i++) {
            System.out.print(q.deQueue() + "\t");
        }
    }

    private static void linearQueueDemo() {
        LQueue q = new LQueue(5);
        q.push(5);
        q.push(10);
        q.push(15);
        q.push(20);
        q.push(25);
        q.push(30);
        q.traverse();

        System.out.println();
        for(int i = 0; i < 6; i++) {
            System.out.print(q.pop() + "\t");
        }
    }
}

package com.ds.course.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        NLinkedList l = new NLinkedList(5);
        l.addLast(10);
        l.addLast(20);
        l.addFirst(0);
        l.add(15, 3);
        l.addLast(25);
        l.addLast(30);
        // 0, 5, 10, 15, 20, 25, 30
        System.out.println("LinkedList elements: " + l);

        l.delete(2);
        l.delete(0);
        l.delete(2);

        System.out.println("LinkedList elements: " + l);

        l.delete(3);

        System.out.println("LinkedList elements: " + l);
    }
}

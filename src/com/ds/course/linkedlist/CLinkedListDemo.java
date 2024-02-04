package com.ds.course.linkedlist;

public class CLinkedListDemo {

    public static void main(String[] args) {
        CLinkedList l = new CLinkedList(10);
        l.add(5, 0);
        l.add(15, 2);
        l.add(25, 3);

        l.traverseList();

        l.add(20, 2);
        l.traverseList();
        l.add(16, 2);

        l.traverseList();

        l.delete(0);
        l.traverseList();
        l.delete(2);
        l.traverseList();
        l.delete(3);
        l.traverseList();
        l.delete(1);
        l.delete(1);
        l.traverseList();
        l.delete(0);
        l.traverseList();
    }
}

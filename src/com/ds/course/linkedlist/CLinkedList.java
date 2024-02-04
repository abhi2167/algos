package com.ds.course.linkedlist;

public class CLinkedList {

    Node head;
    Node tail;
    int size;

    public CLinkedList() {}

    public CLinkedList(int val) {
        this.head = new Node(val);
        this.head.next = this.head;
        this.tail = this.head;
        size++;
    }

    // 5,  10, 15, 20,  25,    30
    // 0 , 1,  2,   3,   4,     5

    public void add(int val, int index) {
        Node node = new Node(val);
        if(index == 0) {
            node.next = this.head;
            this.head = node;
            this.tail.next = this.head;
        } else if (index >= size) {
            this.tail.next = node;
            this.tail = node;
            this.tail.next = this.head;
        } else {
            Node temp = this.head;
            int i = 0;
            while(i < index - 1) {
                temp = temp.next;
                i++;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }

    public void delete(int index) {
        if(index == 0) {
            if(size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.tail.next = this.head;
            }
        } else if(index < size) {
            Node node = this.head;
            int i = 0;
            while(i < index - 1) {
                node = node.next;
                i++;
            }
            node.next = node.next.next;
            if(index == size - 1) {
                this.tail = node;
            }
        }
        size--;
    }

    public void traverseList() {
        System.out.println("\n");
        if(this.head == null) {
            System.out.println("List empty");
            return;
        }
        Node temp = this.head;
        System.out.print("{ ");
        while (temp != this.tail) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.print(" " + temp.val);
        System.out.println(" }\t size : " + size);
    }
    @Override
    public String toString() {
        return "CLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    class Node {
        int val;
        Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}

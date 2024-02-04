package com.ds.course.linkedlist;

public class NLinkedList {
    public Node head;
    public Node tail;

    public int size;

    public NLinkedList() {}

    public NLinkedList(int val) {
        this.head = new Node(val);
        this.tail = this.head;
        size++;
    }

    public void addLast(int val) {
        Node node = new Node(val);
        this.tail.next = node;
        this.tail = node;
        size++;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
        size++;
    }

    public void add(int val, int index) {
        if(this.head == null)
            return;
        if(index == 0) {
            addFirst(val);
        } else if(index >= size) {
            addLast(val);
        } else {
            int i = 0;
            Node temp = this.head;
            while (i < index-1) {
                temp = temp.next;
                i++;
            }
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public void delete(int index) {
        if(index == 0) {
            if ( size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
            }
        } else if (index < size ) {
            int i = 1;
            Node node = this.head;
            while( i < size ) {
                if(index == i) {
                    if(index == size - 1) {
                        node.next = null;
                        this.tail = node;
                    } else {
                        node.next = node.next.next;
                    }
                    break;
                } else {
                    node = node.next;
                }
                i++;
            }
        }
        size--;
    }

    @Override
    public String toString() {
        return "NLinkedList{" +
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
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

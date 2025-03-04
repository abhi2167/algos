package com.ds.leetcode.Arrays.SlowAndFastPointers;

public class RotateLinkedListToTheRight {

    public static void main(String[] args) {
        RotateLinkedListToTheRight o = new RotateLinkedListToTheRight();

        ListNode head = new ListNode(1);
        ListNode current = head;
        for(int i = 2; i <= 8; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        System.out.println(head);
        System.out.println("result after rotating right k times  " + o.rotateRight(head, 3));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode current = head;
        while(current.next != null) {
            len++;
            current = current.next;
        }
        System.out.println(len);
        current.next = head;
        ListNode new_tail = head;
        for(int i=0; i < len-(k%len)-1; i++) {
            new_tail = new_tail.next;
        }
        head = new_tail.next;
        new_tail.next = null;
        System.out.println(new_tail.val);
        return head;
    }
}

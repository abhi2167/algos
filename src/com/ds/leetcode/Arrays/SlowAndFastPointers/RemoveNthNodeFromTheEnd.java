package com.ds.leetcode.Arrays.SlowAndFastPointers;

public class RemoveNthNodeFromTheEnd {

    public static void main(String[] args) {
        RemoveNthNodeFromTheEnd o = new RemoveNthNodeFromTheEnd();
        ListNode head = new ListNode(1);
        ListNode current = head;
        for(int i = 2; i <= 8; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        System.out.println(head);

        System.out.println("result after removing nth node from the end " + o.removeNthFromEnd(head, 3));

        System.out.println("Remove nth node from end one pass ");
        System.out.println("result after removing nth node from the end one pass" + o.removeNthFromEnd_onepass(head, 3));

    }

    public ListNode removeNthFromEnd_onepass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        for(int i = 1; i <= n+1; i++) {
            first = first.next;
        }
        ListNode second = dummy;
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        System.out.println(first);
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        while(current != null) {
            len++;
            current = current.next;
        }
        len -= n;
        current = dummy;
        while(len > 0) {
            len--;
            current = current.next;
        }
        current.next = current.next.next;
        System.out.println(current + " len " + len);
        return head;
    }
}
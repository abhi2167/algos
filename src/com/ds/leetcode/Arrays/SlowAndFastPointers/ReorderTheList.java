package com.ds.leetcode.Arrays.SlowAndFastPointers;

public class ReorderTheList {

    public static void main(String[] args) {
        ReorderTheList o = new ReorderTheList();

        ListNode head = new ListNode(1);
        ListNode current = head;
        for(int i = 2; i <= 8; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        System.out.println(head);
        o.reorderList(head);
        System.out.println("result after reordering the list  " + head);
    }

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow);

        ListNode current = slow;
        ListNode prev = null;
        ListNode temp = null;
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        ListNode first = head;
        ListNode second = prev;
        ListNode tmp;
        while(second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }


    }
}

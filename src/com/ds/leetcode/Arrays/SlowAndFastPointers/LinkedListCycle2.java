package com.ds.leetcode.Arrays.SlowAndFastPointers;

import java.util.List;

public class LinkedListCycle2 {

    public static void main(String[] args) {
        LinkedListCycle2 o = new LinkedListCycle2();
        ListNode head = new ListNode(3);
        ListNode cycleEntrance = new ListNode(2);
        head.next = cycleEntrance;
        cycleEntrance.next = new ListNode(0);
        cycleEntrance.next.next = new ListNode(-4);
        cycleEntrance.next.next.next = cycleEntrance;
        System.out.println("Node where cycle starts  = " + o.detectCycle(head).val);

    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return  slow;
    }
}


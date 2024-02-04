package com.ds.leetcode.Arrays;

public class MergeTwoLinkedLists {

    public static void main(String[] args) {

        MergeTwoLinkedLists s = new MergeTwoLinkedLists();
        ListNode head = s.new ListNode();
        head.val = 1;
        ListNode val1 = s.new ListNode();
        val1.val = 2;
        head.next = val1;

//        ListNode val2 = s.new ListNode();
//        val2.val = 4;
//        val1.next = val2;


        ListNode head2 = s.new ListNode();
        head2.val = 3;
        ListNode val21 = s.new ListNode();
        val21.val = 4;
        head2.next = val21;

//        ListNode val22 = s.new ListNode();
//        val22.val = 4;
//        val21.next = val22;

       //System.out.println("Result " + s.mergeTwoLists(head, head2));
       System.out.println("Result " + s.mergeTwoLists_r(head, head2));
    }

    public ListNode mergeTwoLists_r(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        } else if(list2 == null) {
            return list1;
        } else if(list1.val <= list2.val) {
            list1.next = mergeTwoLists_r(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_r(list1, list2.next);
            return list2;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        System.out.println(list1);
        System.out.println(list2);

        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        if(p2 != null) {
            temp.next = p2;
        } else if(p1 != null) {
            temp.next = p1;
        }
        return  head.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

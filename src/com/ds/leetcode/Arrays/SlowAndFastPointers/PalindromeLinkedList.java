package com.ds.leetcode.Arrays.SlowAndFastPointers;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList o = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        ListNode current = head;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(1);
        System.out.println(head);
        System.out.println("is palindrome result = " + o.isPalindrome(head));
        System.out.println("is palindrome result = " + o.isPalindrome_eff(head));
    }

    public boolean isPalindrome_eff(ListNode head) {
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode reversedSecondHalfStart = reverseSecondHalf(firstHalfEnd.next);
        ListNode first = head;
        ListNode second = reversedSecondHalfStart;
        boolean result = true;
        while(result && second != null) {
            if(first.val != second.val) {
                result = false;
            }
            first = first.next;
            second = second.next;
        }
        //revert back list to original
        firstHalfEnd.next = reverseSecondHalf(reversedSecondHalfStart);
        return result;
    }

    private ListNode reverseSecondHalf(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode temp;
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(current != null) {
            dummy.next = new ListNode(current.val);
            dummy = dummy.next;
            current = current.next;
        }
        ListNode head2 = temp.next;
        current = head2;
        ListNode prev = null;
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        current = head;
        while(current != null) {
            if(current.val != prev.val) {
                return false;
            }
            current = current.next;
            prev = prev.next;
        }

        return true;
    }
}

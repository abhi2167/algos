package com.ds.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author abinay.pingili
 *
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */
public class LinkedListAddTwoNumbers {

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();
        int i1=0, i2=0, carry = 0, sum = 0;
        LinkedList<Integer> result = new LinkedList<>();
    	while(it1.hasNext() || it2.hasNext()) {
    		i1 = it1.hasNext() ? it1.next() : 0;
    		i2 = it2.hasNext() ? it2.next() : 0;
    		sum = i1 + i2 + carry;
    		if(sum > 9) {
    			result.add(sum%10);
    			carry = 1;
    		} else {
    			result.add(sum);
    			carry = 0;
    		}
    	}
    	if(carry != 0) {
    		result.add(carry);
    	}
    	return result;
    }
    
	@SuppressWarnings("serial")
	public static void main( String[] args) {
//		LinkedList<Integer> l1 = new LinkedList<Integer>() {
//			{
//				add(9);
//				add(9);
//				add(9);
//			}
//		};
//		LinkedList<Integer> l2 = new LinkedList<Integer>() {
//			{
//				add(9);
//				add(9);
//				add(9);
//			}
//		};
//		System.out.println("Result ::: " + addTwoNumbers(l1, l2));
		
		
		ListNode s10 = new ListNode(9);
		ListNode s11 = new ListNode(9);
		ListNode s12 = new ListNode(9);
		s10.next = s11;
		s11.next = s12;
		
		ListNode s20 = new ListNode(5);
		ListNode s21 = new ListNode(6);
		ListNode s22 = new ListNode(4);
		s20.next = s21;
		s21.next = s22;
		System.out.println("Result Using ListNode class ::: " + addTwoNumbersListNode(s10, s20));
	}
	
	
    public static ListNode addTwoNumbersListNode(ListNode l1, ListNode l2) {

    	ListNode p = l1;
    	ListNode q = l2;
    	int carry = 0;
    	int sum =0;
    	ListNode resultHead = new ListNode(0);
    	ListNode current = resultHead;
    	while(p != null || q != null) {
    		int i1 = p != null ? p.val : 0;
    		int i2 = q != null ? q.val : 0;
    		sum = i1 + i2 + carry;
    		current.next = new ListNode(sum%10);
    		current = current.next;
    		carry = sum/10;
    		if(p != null) p = p.next;
    		if(q != null) q = q.next;
    	}
    	if ( carry != 0) {
    		current.next = new ListNode(carry);
    		current = current.next;
    	}
    	return resultHead.next;
    	

    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {};
	ListNode(int val) { this.val = val; };
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
	
}

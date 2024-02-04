package com.ds.leetcode.medium;

/**
 * 
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head. Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5]
 * Example 2:
 * 
 * Input: head = [1], n = 1 Output: [] Example 3:
 * 
 * Input: head = [1,2], n = 1 Output: [1]
 *
 */
public class RemoveKthNodeFromList {

	public static void main(String[] args) {
		RemoveKthNodeFromList k = new RemoveKthNodeFromList();
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		// System.out.println("Result :: " + k.removeNthFromEnd(head, 5));
		//System.out.println("Result :: " + k.removeNthFromEnd2(head, 1));
		System.out.println("Result :: " + k.removeNthFromEnd3(head, 2));
	}

	public ListNode removeNthFromEnd3(ListNode head, int n) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		int i = 1;
		while(i <= n+1) {
			i++;
			first = first.next;
		}
		System.out.println("first " + first.val);
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		current.next = head;
		ListNode targetNode = current;
		int delay = 0;
		while(current.next != null) {
			
			if(delay >= n ) {
				targetNode = targetNode.next;
			}
			delay++;
			current = current.next;
		}
		if (targetNode == dummy)
			head = head.next;
		else 
			targetNode.next = targetNode.next.next;
		
		return head;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null || (head.next == null && n == 1)) {
			return head;
		}

		ListNode current = head;
		ListNode nextNode = head.next;
		int size = 2;
		while (nextNode.next != null) {
			size++;
			current = current.next;
			nextNode = nextNode.next;
		}
		if (n == 1) {
			current.next = null;
		} else {
			int targetIndex = size - n;
			int i = 1;
			ListNode target = head;
			while (i <= targetIndex) {
				target = target.next;
				i++;
			}
			target.val = target.next.val;
			target.next = target.next.next;
		}
		return head;
	}
}

class ListNode {
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
		StringBuilder listStr = new StringBuilder("");
		ListNode node = this;
		while (node != null) {
			listStr.append(node.val + ",");
			node = node.next;
		}
		return listStr.toString();
	}

}
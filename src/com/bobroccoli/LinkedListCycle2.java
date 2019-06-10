package com.bobroccoli;

public class LinkedListCycle2 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head, find = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				while (find != slow) {
					slow = slow.next;
					find = find.next;
				}
				return find;
			}
		}
		return null;
	}
}

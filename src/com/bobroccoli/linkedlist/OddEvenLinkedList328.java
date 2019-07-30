package com.bobroccoli.linkedlist;

public class OddEvenLinkedList328 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode oddHead = head, evenHead = head.next, next = evenHead.next;
		ListNode oddTail = oddHead, evenTail = evenHead;
		int index = 3;
		while (next != null) {
			if (index % 2 == 1) {
				oddTail.next = next;
				oddTail = oddTail.next;
				next = next.next;
			} else {
				evenTail.next = next;
				evenTail = evenTail.next;
				next = next.next;
			}
			++index;
		}
		if (evenTail.next != null)
			evenTail.next = null;
		oddTail.next = evenHead;
		return oddHead;
	}
}

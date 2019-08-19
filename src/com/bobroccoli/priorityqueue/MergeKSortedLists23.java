package com.bobroccoli.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class MergeKSortedLists23 {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});
		ListNode dummy = new ListNode(0);
		for (int i = 0; i < lists.length; ++i) {
			if (lists[i] != null)
				pq.offer(lists[i]);
		}
		ListNode cur = dummy;
		while (!pq.isEmpty()) {
			ListNode top = pq.poll();
			if (top.next != null)
				pq.offer(top.next);
			cur.next = top;
			cur = cur.next;
		}
		return dummy.next;
	}
}

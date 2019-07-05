package com.bobroccoli.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer138 {
	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {
		}

		public Node(int _val, Node _next, Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node dummyNode = new Node(), constructor = dummyNode, helperNode = head;
		Map<Node, Node> map = new HashMap<Node, Node>();
		while (helperNode != null) {
			constructor.next = new Node();
			constructor.next.val = helperNode.val;
			map.put(helperNode, constructor.next);
			helperNode = helperNode.next;
			constructor = constructor.next;
		}
		constructor = dummyNode;
		helperNode = head;
		while (helperNode != null) {
			if (helperNode.random != null)
				constructor.next.random = map.get(helperNode.random);
			helperNode = helperNode.next;
			constructor = constructor.next;
		}
		return dummyNode.next;
	}
}

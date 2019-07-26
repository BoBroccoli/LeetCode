package com.bobroccoli.linkedlistdouble;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
	class DouLinkedList {
		DouLinkedList prev, next;
		int val, key;
	}

	Map<Integer, DouLinkedList> map = null;
	int capacity = 0, curSize = 0;
	DouLinkedList tail, head;

	public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DouLinkedList>();
        
        head = new DouLinkedList();
        tail = new DouLinkedList();
        head.next = tail;
        tail.prev = head;
    }

	public int get(int key) {
		DouLinkedList node = map.get(key);
		if (node == null)
			return -1;
		moveToHead(node);
		return node.val;
	}

	public void put(int key, int value) {
		if (!map.containsKey(key)) {
			++curSize;
			if (curSize > capacity) {
				System.out.println(tail.prev.val);
				map.remove(tail.prev.key);
				removeNode(tail.prev);
				--curSize;
			}
			DouLinkedList node = new DouLinkedList();
			node.val = value;
			node.key = key;
			addNode(node);
			map.put(key, node);
		} else {
			DouLinkedList node = map.get(key);
			node.val = value;
			moveToHead(node);
		}
	}

	public void moveToHead(DouLinkedList node) {
		removeNode(node);
		addNode(node);
	}

	public void removeNode(DouLinkedList node) {
		DouLinkedList prev = node.prev, next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	public void addNode(DouLinkedList node) {
		node.next = head.next;
		node.prev = head;

		head.next.prev = node;
		head.next = node;
	}
}

package com.bobroccoli.stack;

import java.util.Stack;

public class MinStack155 {
	Stack<Integer> stack = null;
	Stack<Integer> minStack = null;

	public MinStack155() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
	}

	public void pop() {
		int x = stack.pop();
		if (x == minStack.peek())
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
	
}

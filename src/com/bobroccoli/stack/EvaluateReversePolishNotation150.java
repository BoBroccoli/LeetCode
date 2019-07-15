package com.bobroccoli.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < tokens.length; ++i) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				Integer b = stack.pop();
				Integer a = stack.pop();
				switch (tokens[i]) {
				case "+": {
					stack.push(a + b);
					break;
				}
				case "-": {
					stack.push(a - b);
					break;
				}
				case "*": {
					stack.push(a * b);
					break;
				}
				case "/": {
					stack.push(a / b);
					break;
				}
				}
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}
}
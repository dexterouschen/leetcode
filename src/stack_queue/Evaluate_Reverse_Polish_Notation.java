package stack_queue;

import java.util.*;

public class Evaluate_Reverse_Polish_Notation {
	/**
	 * Reverse Polish Notation uses a stack to do calculation.
	 */
	public static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a + b);
			} else if (tokens[i].equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a - b);
			} else if (tokens[i].equals("*")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a * b);
			} else if (tokens[i].equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a / b);
			} else {
				stack.add(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] t1 = { "2", "1", "+", "3", "*" };
		String[] t2 = { "4", "13", "5", "/", "+" };
		String[] t3 = { "0", "3", "/" };
		System.out.println(evalRPN(t1));
		System.out.println(evalRPN(t2));
		System.out.println(evalRPN(t3));
	}

}

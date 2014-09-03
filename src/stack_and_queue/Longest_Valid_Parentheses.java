package stack_and_queue;

import java.util.*;

/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class Longest_Valid_Parentheses {
	/**
	 * This problem can be solved by using stack.
	 * The stack stores the index of "unpaired parenthesis":
	 * push if s[i]=='(';
	 * pop if s[i]==')' and stack.peek() =='('.
	 * Current length of continuous parenthesis is "i - stack.peek()" or
	 * "i + 1" if stack is empty.
	 */
	public static int longestValidParentheses(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (!stack.isEmpty() && array[i] == ')' && array[stack.peek()] == '(') {
				stack.pop();
				if (stack.isEmpty())
					max = i + 1;
				else
					max = Math.max(max, i - stack.peek());
			} else {
				stack.push(i);
			}
		}
		return max;
	}

	/**
	 * Another implementation: the same idea, but uses two stacks.
	 */
	public static int longestValidParentheses2(String s) {
		Stack<Character> charStack = new Stack<>();
		Stack<Integer> indexStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (charStack.isEmpty()) {
				charStack.add(s.charAt(i));
				indexStack.add(i);
				continue;
			}
			if (s.charAt(i) == ')' && charStack.peek() == '(') {
				charStack.pop();
				indexStack.pop();
			} else {
				charStack.add(s.charAt(i));
				indexStack.add(i);
			}
		}
		if (indexStack.isEmpty()) {
			return s.length();
		}
		int max = 0, end = s.length();
		while (!indexStack.isEmpty()) {
			int start = indexStack.pop();
			max = Math.max(max, end - start - 1);
			end = start;
		}
		max = Math.max(max, end);
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()")); // return 2
		System.out.println(longestValidParentheses("(()")); // return 2
		System.out.println(longestValidParentheses(")()())")); // return 4
		System.out.println(longestValidParentheses("()(()")); // return 2
	}

}

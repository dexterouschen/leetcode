package stack_queue;

import java.util.*;

/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class Longest_Valid_Parentheses {

	// stack stores the index of "unpaired parenthesis"
	// push if s[i]=='('
	// pop if s[i]==')' and stack.peek() =='('
	// current length of continuous parenthesis is "i - stack.peek()" or
	// "i + 1" if stack is empty.

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

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()")); // return 2
		System.out.println(longestValidParentheses("(()")); // return 2
		System.out.println(longestValidParentheses(")()())")); // return 4
		System.out.println(longestValidParentheses("()(()")); // return 2
	}

}

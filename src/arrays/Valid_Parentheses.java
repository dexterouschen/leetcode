package arrays;

import java.util.HashMap;
import java.util.Stack;

/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Valid_Parentheses {

	public static boolean isValid(String s) {
		char[] charArray = s.toCharArray();

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for (Character c : charArray) {
			if (map.keySet().contains(c)) {
				stack.push(c);
			} else if (map.values().contains(c)) {
				if (!stack.isEmpty() && map.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String a = "(({)([){}[]][)]}";
		String b = "({[})])";
		String c = "([]){[([])]}";
		// System.out.println(a.charAt(0));
		System.out.println(isValid(a)); // should be false
		System.out.println(isValid(b)); // should be false
		System.out.println(isValid(c)); // should be true
	}
}

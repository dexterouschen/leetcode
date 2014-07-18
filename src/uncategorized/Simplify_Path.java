package uncategorized;

import java.util.Stack;

/*
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 click to show corner cases.

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class Simplify_Path {

	public static String simplifyPath(String path) {
		Stack<String> s = new Stack<String>();
		String[] split = path.split("/");
		for (String a : split) {
			if (!a.equals(".") && !a.isEmpty()) {
				if (a.equals("..")) {
					if (!s.isEmpty()) {
						s.pop();
					}
				} else {
					s.push(a);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			sb.insert(0, s.pop());
			sb.insert(0, "/");
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

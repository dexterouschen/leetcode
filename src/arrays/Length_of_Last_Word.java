package arrays;

/*
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example, 
 Given s = "Hello World",
 return 5.
 */

public class Length_of_Last_Word {

	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		StringBuffer sb = new StringBuffer(s);
		int len = 0;
		if (sb.charAt(0) != ' ') {
			len++;
		}
		for (int i = 1; i < sb.length(); i++) {
			if (sb.charAt(i) != ' ' && sb.charAt(i - 1) == ' ') {
				len = 1;
			} else if (sb.charAt(i) != ' ' && sb.charAt(i - 1) != ' ') {
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		String s = "    Hello,      world  ";
		System.out.println(lengthOfLastWord(s));

	}

}

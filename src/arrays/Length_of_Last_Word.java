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
		int lastLen = 0;
		if (s == null || s.length() == 0) {
			return 0;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				lastLen++;
			} else if (i < s.length() - 1 && s.charAt(i + 1) != ' ') {
				lastLen = 0;
			}
		}
		return lastLen;
	}

	public static void main(String[] args) {
		String s = "    Hello,      world  ";
		System.out.println(lengthOfLastWord(s));

	}

}

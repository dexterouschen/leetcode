package arrays;

/*
 Write a function to find the longest common prefix string amongst an array of strings.
 */

public class Longest_Common_Prefix {
	/*
	 * Use an index to check is a char is the same in all strings at position
	 * index.
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		StringBuffer sb = new StringBuffer();
		int index = 0;
		while (true) {
			char c;
			if (strs[0].length() < index + 1)
				break;
			else
				c = strs[0].charAt(index);
			if (isAllSame(strs, index, c)) {
				sb.append(c);
				index++;
			} else {
				break;
			}
		}
		return sb.toString();
	}

	public static boolean isAllSame(String[] strs, int index, char c) {
		for (int i = 0; i < strs.length; i++)
			if (strs[i].length() < index + 1 || strs[i].charAt(index) != c)
				return false;
		return true;
	}

	public static void main(String[] args) {
		String a = "abcdefg";
		String b = "abcdfg";
		String c = "abcdg";
		String[] strs = new String[3];
		strs[0] = a;
		strs[1] = b;
		strs[2] = c;
		System.out.println(longestCommonPrefix(strs));
		String[] strs2 = new String[1];
		strs2[0] = "a";
		System.out.println(longestCommonPrefix(strs2));
	}

}

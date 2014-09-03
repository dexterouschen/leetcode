package array_and_linear_structures;

/*
 Implement strStr().

 Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */

public class Implement_strStr {

	public static String strStr(String haystack, String needle) {
		if (haystack == null || needle == null || (needle.isEmpty() && !haystack.isEmpty())) {
			return haystack;
		}
		if (haystack.isEmpty() && needle.isEmpty()) {
			return "";
		}
		if (haystack.length() < needle.length()) {
			return null;
		}
		int hLen = haystack.length(), nLen = needle.length();
		int head = 0;
		while (head <= hLen - nLen) {
			int curSearch = 0;
			while (haystack.charAt(head + curSearch) == needle.charAt(curSearch)) {
				if (curSearch == nLen - 1) {
					return haystack.substring(head);
				}
				curSearch++;
			}
			head++;
		}
		return null;
	}

	public static void main(String[] args) {
		// String s1 = "hello world, my beatiful world", s2 = "world";
		String s1 = "mississippi", s2 = "issip";
		System.out.println(strStr(s1, s2));
	}

}

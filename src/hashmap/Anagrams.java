package hashmap;

import java.util.*;

/*
 Given an array of strings, return all groups of strings that are anagrams.

 Note: All inputs will be in lower-case.
 */

public class Anagrams {
	/**
	 * The question should be stated in this way for better understanding:
	 * "Given an array of strings, return all strings that have their anagrams in this array."
	 * So the easiest way to do so is by implementing a hash-map. The keys of
	 * this map are the sorted char arrays of each string, and the values of the
	 * map are the strings.
	 */
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> list = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return list;
		}
		Map<String, ArrayList<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String ns = new String(chars);
			if (!map.containsKey(ns)) {
				ArrayList<String> element = new ArrayList<String>();
				element.add(s);
				map.put(ns, element);
			} else {
				map.get(ns).add(s);
			}
		}
		for (String s : map.keySet()) {
			if (map.get(s).size() > 1)
				list.addAll(map.get(s));
		}
		return list;
	}

	public static void main(String[] args) {
		String[] strs = { "abc", "aac", "acb", "bca", "aca", "ccb", "abb" };
		System.out.println(anagrams(strs));
	}

}

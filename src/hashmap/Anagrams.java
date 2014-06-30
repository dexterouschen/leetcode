package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 Given an array of strings, return all groups of strings that are anagrams.

 Note: All inputs will be in lower-case.
 */

public class Anagrams {
	// build a hashmap in which the ordered char arrays are keys. Each key
	// corresponds to a arraylist containing anagram strings.
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> list = new ArrayList<String>();
		if (strs == null || strs.length == 0) {
			return list;
		}
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
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

package recursion;

/*
 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "a*") ¡ú true
 isMatch("aa", ".*") ¡ú true
 isMatch("ab", ".*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú true
 */

public class Regular_Expression_Matching {
	/**
	 * Here I used a recursive approach to solve this problem. 
	 */
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		// if p's length is 1, then s must also be of length 1 and (p == s or p
		// == '.')
		if (p.length() == 1) {
			return (s.length() == 1) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
		}
		// if second char in p is not '*': s[0] must match p[0] and
		// s.substring(1) must match p.substring(1)
		if (p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			} else {
				return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
						&& isMatch(s.substring(1), p.substring(1));
			}
		}
		// When second char in p IS '*': iterate until s[i] is not equal to p[0]
		// (remember p[1] == '*'). During iteration, if s matches
		// p.substring(2), then return true directly; else subtract s as s =
		// s.substring(1). When iteration is completed, return is s matches
		// p.substring(2).
		while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}
		return isMatch(s, p.substring(2));
	}

	public static void main(String[] args) {

	}

}

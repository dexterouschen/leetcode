package dynamic_programming;

import java.util.*;

/*
 Given a string s and a dictionary of words dict, 
 determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */

public class Word_Break {

	// Define: possible[i] represents whether s[0,i] can be segmented by
	// dictionary.
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.isEmpty())
			return true;
		if (dict == null || dict.isEmpty())
			return false;
		boolean[] possible = new boolean[s.length()];
		possible[0] = dict.contains(s.substring(0, 1)) ? true : false;
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i + 1))) { // if dict contains
														// s[0,i]
				possible[i] = true;
			} else if (hasBreakPoint(s, dict, possible, i)) { // see below
				possible[i] = true;
			} else { // else possible must be false
				possible[i] = false;
			}
		}

		return possible[s.length() - 1];
	}

	// checks if there is a break point "k" that possible[k] is true and
	// s.substring(k,i+1) is in dictionary
	public static boolean hasBreakPoint(String s, Set<String> dict, boolean[] possible, int index) {
		for (int i = 0; i < index; i++) {
			if (possible[i] == true && dict.contains(s.substring(i + 1, index + 1))) {
				return true;
			}
		}
		return false;
	}

	public static boolean wordBreakRecursion(String s, Set<String> dict) {
		if (s == null || s.isEmpty())
			return true;
		if (dict == null || dict.isEmpty())
			return false;
		int index = 1;
		boolean result = false;
		result = segment(s, dict, index);
		return result;
	}

	public static boolean segment(String s, Set<String> dict, int index) {
		if (dict.contains(s))
			return true;
		if (index == s.length()) {
			if (dict.contains(s))
				return true;
			else
				return false;
		}
		boolean result1 = false;
		if (dict.contains(s.substring(0, index))) {
			result1 = segment(s.substring(index), dict, 1);
		}
		return result1 || segment(s, dict, index + 1);
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		// dict.add("leet");
		// dict.add("code");
		// dict.add("aaaa");
		// dict.add("aaa");
		String[] a = { "kfomka", "hecagbngambii", "anobmnikj", "c", "nnkmfelneemfgcl", "ah",
				"bgomgohl", "lcbjbg", "ebjfoiddndih", "hjknoamjbfhckb", "eioldlijmmla",
				"nbekmcnakif", "fgahmihodolmhbi", "gnjfe", "hk", "b", "jbfgm", "ecojceoaejkkoed",
				"cemodhmbcmgl", "j", "gdcnjj", "kolaijoicbc", "liibjjcini", "lmbenj",
				"eklingemgdjncaa", "m", "hkh", "fblb", "fk", "nnfkfanaga", "eldjml", "iejn",
				"gbmjfdooeeko", "jafogijka", "ngnfggojmhclkjd", "bfagnfclg", "imkeobcdidiifbm",
				"ogeo", "gicjog", "cjnibenelm", "ogoloc", "edciifkaff", "kbeeg", "nebn", "jdd",
				"aeojhclmdn", "dilbhl", "dkk", "bgmck", "ohgkefkadonafg", "labem", "fheoglj",
				"gkcanacfjfhogjc", "eglkcddd", "lelelihakeh", "hhjijfiodfi", "enehbibnhfjd", "gkm",
				"ggj", "ag", "hhhjogk", "lllicdhihn", "goakjjnk", "lhbn", "fhheedadamlnedh", "bin",
				"cl", "ggjljjjf", "fdcdaobhlhgj", "nijlf", "i", "gaemagobjfc", "dg", "g",
				"jhlelodgeekj", "hcimohlni", "fdoiohikhacgb", "k", "doiaigclm", "bdfaoncbhfkdbjd",
				"f", "jaikbciac", "cjgadmfoodmba", "molokllh", "gfkngeebnggo", "lahd", "n",
				"ehfngoc", "lejfcee", "kofhmoh", "cgda", "de", "kljnicikjeh", "edomdbibhif",
				"jehdkgmmofihdi", "hifcjkloebel", "gcghgbemjege", "kobhhefbbb", "aaikgaolhllhlm",
				"akg", "kmmikgkhnn", "dnamfhaf", "mjhj", "ifadcgmgjaa", "acnjehgkflgkd", "bjj",
				"maihjn", "ojakklhl", "ign", "jhd", "kndkhbebgh", "amljjfeahcdlfdg", "fnboolobch",
				"gcclgcoaojc", "kfokbbkllmcd", "fec", "dljma", "noa", "cfjie", "fohhemkka",
				"bfaldajf", "nbk", "kmbnjoalnhki", "ccieabbnlhbjmj", "nmacelialookal",
				"hdlefnbmgklo", "bfbblofk", "doohocnadd", "klmed", "e", "hkkcmbljlojkghm",
				"jjiadlgf", "ogadjhambjikce", "bglghjndlk", "gackokkbhj", "oofohdogb",
				"leiolllnjj", "edekdnibja", "gjhglilocif", "ccfnfjalchc", "gl", "ihee",
				"cfgccdmecem", "mdmcdgjelhgk", "laboglchdhbk", "ajmiim", "cebhalkngloae",
				"hgohednmkahdi", "ddiecjnkmgbbei", "ajaengmcdlbk", "kgg", "ndchkjdn",
				"heklaamafiomea", "ehg", "imelcifnhkae", "hcgadilb", "elndjcodnhcc", "nkjd",
				"gjnfkogkjeobo", "eolega", "lm", "jddfkfbbbhia", "cddmfeckheeo", "bfnmaalmjdb",
				"fbcg", "ko", "mojfj", "kk", "bbljjnnikdhg", "l", "calbc", "mkekn", "ejlhdk",
				"hkebdiebecf", "emhelbbda", "mlba", "ckjmih", "odfacclfl", "lgfjjbgookmnoe",
				"begnkogf", "gakojeblk", "bfflcmdko", "cfdclljcg", "ho", "fo", "acmi",
				"oemknmffgcio", "mlkhk", "kfhkndmdojhidg", "ckfcibmnikn", "dgoecamdliaeeoa",
				"ocealkbbec", "kbmmihb", "ncikad", "hi", "nccjbnldneijc", "hgiccigeehmdl",
				"dlfmjhmioa", "kmff", "gfhkd", "okiamg", "ekdbamm", "fc", "neg", "cfmo",
				"ccgahikbbl", "khhoc", "elbg", "cbghbacjbfm", "jkagbmfgemjfg", "ijceidhhajmja",
				"imibemhdg", "ja", "idkfd", "ndogdkjjkf", "fhic", "ooajkki", "fdnjhh", "ba",
				"jdlnidngkfffbmi", "jddjfnnjoidcnm", "kghljjikbacd", "idllbbn", "d",
				"mgkajbnjedeiee", "fbllleanknmoomb", "lom", "kofjmmjm", "mcdlbglonin", "gcnboanh",
				"fggii", "fdkbmic", "bbiln", "cdjcjhonjgiagkb", "kooenbeoongcle",
				"cecnlfbaanckdkj", "fejlmog", "fanekdneoaammb", "maojbcegdamn", "bcmanmjdeabdo",
				"amloj", "adgoej", "jh", "fhf", "cogdljlgek", "o", "joeiajlioggj", "oncal", "lbgg",
				"elainnbffk", "hbdi", "femcanllndoh", "ke", "hmib", "nagfahhljh",
				"ibifdlfeechcbal", "knec", "oegfcghlgalcnno", "abiefmjldmln", "mlfglgni",
				"jkofhjeb", "ifjbneblfldjel", "nahhcimkjhjgb", "cdgkbn", "nnklfbeecgedie",
				"gmllmjbodhgllc", "hogollongjo", "fmoinacebll", "fkngbganmh", "jgdblmhlmfij",
				"fkkdjknahamcfb", "aieakdokibj", "hddlcdiailhd", "iajhmg", "jenocgo", "embdib",
				"dghbmljjogka", "bahcggjgmlf", "fb", "jldkcfom", "mfi", "kdkke", "odhbl", "jin",
				"kcjmkggcmnami", "kofig", "bid", "ohnohi", "fcbojdgoaoa", "dj", "ifkbmbod",
				"dhdedohlghk", "nmkeakohicfdjf", "ahbifnnoaldgbj", "egldeibiinoac", "iehfhjjjmil",
				"bmeimi", "ombngooicknel", "lfdkngobmik", "ifjcjkfnmgjcnmi", "fmf", "aoeaa", "an",
				"ffgddcjblehhggo", "hijfdcchdilcl", "hacbaamkhblnkk", "najefebghcbkjfl",
				"hcnnlogjfmmjcma", "njgcogemlnohl", "ihejh", "ej", "ofn", "ggcklj", "omah", "hg",
				"obk", "giig", "cklna", "lihaiollfnem", "ionlnlhjckf", "cfdlijnmgjoebl",
				"dloehimen", "acggkacahfhkdne", "iecd", "gn", "odgbnalk", "ahfhcd", "dghlag",
				"bchfe", "dldblmnbifnmlo", "cffhbijal", "dbddifnojfibha", "mhh", "cjjol", "fed",
				"bhcnf", "ciiibbedklnnk", "ikniooicmm", "ejf", "ammeennkcdgbjco", "jmhmd", "cek",
				"bjbhcmda", "kfjmhbf", "chjmmnea", "ifccifn", "naedmco", "iohchafbega",
				"kjejfhbco", "anlhhhhg" };
		// String[] b = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
		// "aaaaaaa", "aaaaaaaa",
		// "aaaaaaaaa", "aaaaaaaaaa" };
		for (String i : a) {
			dict.add(i);
		}
		// for (String i : b) {
		// dict.add(i);
		// }

		// String s = "leetcode";
		// String s2 = "letcode";
		// String s = "aaaaaaa";
		String s = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami";
		// String s =
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(wordBreak(s, dict));
		// System.out.println(wordBreakRecursion(s2, dict));
	}
}

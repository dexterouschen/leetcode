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
	/**
	 * Recursive solution is obvious. And thus we know there must be a DP solution 
	 * with better time complexity. (You know what an interviewer expects, right?) 
	 * Intuitively, we can build a boolean array "inDict" such that inDict[i]
	 * represents the result if s[0, i] can be broke and found in "dict". 
	 * So how do we know if s[0, i] is true? It must be two cases:
	 * (1) s[0, i] can be found in dictionary, or
	 * (2) there exists a point 'k' where s[0, k] AND s[k + 1, i] are in dictionary. Here is 
	 *		 why we need DP: we have already stored whether s[0, k] is in dictionary, as 
	 *      it is inDict[k] == true or false. 
	 * 
	 * This algorithm, however, is not O(n) complexity in time. It's worst case 
	 * complexity is O(n^2).
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.isEmpty())
			return true;
		if (dict == null || dict.isEmpty())
			return false;
		boolean[] inDict = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				inDict[i] = true;
			} else if (hasBreakPoint(s, dict, inDict, i)) {
				inDict[i] = true;
			} else {
				inDict[i] = false;
			}
		}
		return inDict[inDict.length - 1];
	}

	// checks if there is a break point "k" that possible[k] is true and
	// s.substring(k,i+1) is in dictionary
	public static boolean hasBreakPoint(String s, Set<String> dict, boolean[] inDict, int index) {
		for (int i = 0; i < index; i++) {
			if (inDict[i] == true && dict.contains(s.substring(i + 1, index + 1))) {
				return true;
			}
		}
		return false;
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

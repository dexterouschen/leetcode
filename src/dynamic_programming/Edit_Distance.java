package dynamic_programming;

/*
 Given two words word1 and word2, 
 find the minimum number of steps required to convert word1 to word2.
 (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */

public class Edit_Distance {
	/**
	 * A typical DP problem. Assume in a table int[][] distance, distance[i][j] represents 
	 * a table that describes the edit distance from substring word1.substring(0, i) 
	 * to substring word2.substring(0, j).
	 * 
	 *  Now we need to compare the two LAST chars: word1[i] and word2[j].
	 *  
	 *  If word1[i] == word2[j], we don't need to edit anything from word1 to word2, so 
	 *  distance[i][j] = distance[i - 1][j - 1].
	 *  
	 *  If word1[i] != word2[j], there could be three different conditions as we have three
	 *  operations:
	 *      replace word1[i]: distance[i][j] = distance[i - 1][j - 1] + 1;
	 *      delete word1[i]: delete distance[i][j] = distance[i - 1][j] + 1;
	 *      add word1[i]: distance[i][j] = distance[i][j - 1] + 1;
	 *  distance[i][j] must be equal to the minimum one in whose three conditions.
	 *  
	 * Reference:
	 * http://yucoding.blogspot.com/2013/09/leetcode-question-29-edit-distance.html
	 */
	public static int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}
		int[][] distance = new int[word1.length() + 1][word2.length() + 1];
		// build the edge
		for (int i = 0; i < word1.length() + 1; i++) {
			distance[i][0] = i;
		}
		for (int i = 0; i < word2.length() + 1; i++) {
			distance[0][i] = i;
		}
		// DP build the table
		for (int i = 1; i < word1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {
				distance[i][j] = Math.min(
						(word1.charAt(i - 1) == word2.charAt(j - 1) ? distance[i - 1][j - 1]
								: distance[i - 1][j - 1] + 1), Math.min(distance[i][j - 1] + 1,
								distance[i - 1][j] + 1));
			}
		}
		return distance[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		System.out.println(minDistance("hello", "how")); // should be 4
		System.out.println(minDistance("a", "b")); // should be 1
	}

}

package trees_and_graphs;

/*
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2    1
 \        /     /      / \      \
 3     2     1      1   3      2
 /     /       \                      \
 2  1         2                       3
 */

public class Unique_BST {

	/*
	 * for any picking number which is set as the root, the number of possible
	 * BST is equal to # of left subtree * # of right subtree, in which # of
	 * left subtree = numTree(left numbers) and # of right subtree =
	 * numTrees(right numbers). Take {1, 2, 3, 4, 5, 6} as an example: when
	 * picking 3 as the root, the total number of trees is equal to left subtree
	 * {1, 2{ times right subtree{4, 5, 6}: # total = numTrees(2) * numTrees(3);
	 */
	public static int numTrees(int n) {
		if (n <= 1)
			return 1;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += numTrees(i - 1) * numTrees(n - i);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}

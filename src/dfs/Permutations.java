package dfs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

import test_data_structure.TreeNode;
import trees_and_graphs.Binary_Tree_Preorder_Traversal.State;

/*
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		if (num == null) {
			return null;
		}
		int len = num.length;
		boolean[] isVisited = new boolean[len];
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (len == 0) {
			return lists;
		}
		dfs(num, lists, list, isVisited);
		return lists;
	}

	public static void dfs(int[] num, ArrayList<ArrayList<Integer>> lists,
			ArrayList<Integer> list, boolean[] isVisited) {
		int len = num.length;
		if (list.size() == len) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < len; i++) {
			if (isVisited[i] == false) { // meaning num[i] is not visited
				list.add(num[i]);
				isVisited[i] = true;
				dfs(num, lists, list, isVisited);
				int index = list.indexOf(num[i]);
				list.remove(index);
				isVisited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> list = permute(num);
		System.out.println(list);
	}
}

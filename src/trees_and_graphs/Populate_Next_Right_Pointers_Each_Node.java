package trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import test_data_structure.TreeLinkNode;
import test_data_structure.TreeLink;

/*
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node.
 If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:
 You may only use constant extra space.
 You may assume that it is a perfect binary tree
 (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */

public class Populate_Next_Right_Pointers_Each_Node {
	// public static ArrayList<TreeLinkNode> list = new
	// ArrayList<TreeLinkNode>();
	// public static ArrayList<TreeLinkNode> nullList = new
	// ArrayList<TreeLinkNode>();

	public static void connect(TreeLinkNode root) {
  		ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
	ArrayList<TreeLinkNode> LastNodes = new ArrayList<TreeLinkNode>();
	// 1. BFS to print a list of nodes
	Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	if (root == null) { // if node is null
		return;
	}
	queue.add(root);
	while (!queue.isEmpty()) {
		TreeLinkNode node = (TreeLinkNode) queue.poll();
		list.add(node);
		if (node.left != null && node.right != null) {
			queue.add(node.left);
			queue.add(node.right);
		}
	}
	// 2. using BFS to link all nodes
	for (int i = 0; i < list.size() - 1; i++) {
		list.get(i).next = list.get(i + 1);
	}
	// 3. find the LAST node on each layer, re-link them to NULL
	TreeLinkNode current = root;
	while (current != null) {
		LastNodes.add(current);
		current = current.right;
	}
	for (int i = 0; i < LastNodes.size(); i++) {
		LastNodes.get(i).next = null;
	}  
}

	public static void main(String[] args) {
		// TreeLink tree = new TreeLink();
		// connect(tree.root);
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		connect(n1);
		System.out.println(n4.next); // should be 5

	}
}

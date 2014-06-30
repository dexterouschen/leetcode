package trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import test_data_structure.TreeLink;
import test_data_structure.TreeLinkNode;

public class Populating_Next_Right_Pointers_in_Each_Node_II {

	public static void connect(TreeLinkNode root) {
		ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
		ArrayList<Integer> indexList = new ArrayList<Integer>();

		// 1. BFS to print a list of nodes
		// Keep an indexQ so that the level of each node is also recorded
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		Queue<Integer> indexQ = new LinkedList<Integer>();
		int level = 0;
		if (root == null) { // if node is null
			return;
		}
		queue.add(root);
		indexQ.add(level);
		while (!queue.isEmpty()) {
			TreeLinkNode node = (TreeLinkNode) queue.poll();
			int index = indexQ.poll();
			list.add(node);
			indexList.add(index);
			if (node.left != null) {
				queue.add(node.left);
				indexQ.add(index + 1);
			}
			if (node.right != null) {
				queue.add(node.right);
				indexQ.add(index + 1);
			}
		}
		// 2. using BFS to link all nodes
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).next = list.get(i + 1);
		}

		// 3. using indexList to link each node at the end of a layer to null
		int i = 0;
		while (i < indexList.size() - 1) {
			// ith element in 'list' is a node at the end of a layer
			if (indexList.get(i) != indexList.get(i + 1)) {
				list.get(i).next = null;
			}
			i++;
		}
		list.get(indexList.size() - 1).next = null;
	}

	public static void main(String[] args) {
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		// n1.left = n2;
		// n1.right = n3;
		// n2.left = n4;
		// n3.right = n5;

		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n3.left = n5;
		connect(n1);
		System.out.println(n1.next);
	}

}

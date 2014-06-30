package test_data_structure;

public class Tree {
	public TreeNode root;

	public Tree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		// TreeNode node8 = new TreeNode(8);

		this.root = node4;

		node2.left = node1;
		node1.parent = node2;
		node2.right = node3;
		node3.parent = node2;
		node6.left = node5;
		node5.parent = node6;
		node6.right = node7;
		node7.parent = node6;
		node4.left = node2;
		node2.parent = node4;
		node4.right = node6;
		node6.parent = node4;
		// node8.parent = node7;
		// node7.right = node8;
	}

	public int getSize() {
		return root.getTreeSize();
	}

}

package test_data_structure;

public class TreeLink {
	public TreeLinkNode root;

	public TreeLink() {
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);

		this.root = node4;

		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		node4.left = node2;
		node4.right = node6;
	}

}

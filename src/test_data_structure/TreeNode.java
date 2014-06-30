package test_data_structure;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int val;
	public Enum<State> state;

	public TreeNode(int n) {
		this.val = n;
		this.state = State.unvisited;
	}

	public int getTreeSize() {
		int count = 1;
		int l = 0;
		int r = 0;
		if (this.left != null) {
			l = this.left.getTreeSize();
		}
		if (this.right != null) {
			r = this.right.getTreeSize();
		}
		return count + l + r;
	}

	public enum State {
		visited, unvisited, visiting;
	}

}

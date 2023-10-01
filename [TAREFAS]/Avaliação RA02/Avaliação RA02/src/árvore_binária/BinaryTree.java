package árvore_binária;

public class BinaryTree {
	
	private BinaryTreeNode root;
	
	public BinaryTree() {
		this.setRoot(null);
	}
	
	public BinaryTree(BinaryTreeNode root) {
		this.setRoot(root);
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	public void insert(int value) {
		if (root == null) {
			root = new BinaryTreeNode(value);
		} else {
			root.insert(value);
		}
	}
	
	public void remove(int value) {
		BinaryTreeNode.remove(root, value);
	}
	
	public BinaryTreeNode getNode(int value) {
		return root.getNode(value);
	}
	
	public int getHeight() {
		return BinaryTreeNode.getHeight(root);
	}
	
	public int getBalancing() {
		return root.getBalancing();
	}
	
	public String toString() {
		return root.toString();
	}

}

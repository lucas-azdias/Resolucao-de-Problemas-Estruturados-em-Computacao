package árvore_binária;

public class BinaryTreeAVL {
	
	private BinaryTreeNodeAVL root;
	
	public BinaryTreeAVL() {
		this.setRoot(null);
	}
	
	public BinaryTreeAVL(BinaryTreeNodeAVL root) {
		this.setRoot(root);
	}

	public void setRoot(BinaryTreeNodeAVL root) {
		this.root = root;
	}
	
	public void insert(int value) {
		if (root == null) {
			root = new BinaryTreeNodeAVL(value);
		} else {
			setRoot(BinaryTreeNodeAVL.insert(root, value));
		}
	}
	
	public void remove(int value) {
		BinaryTreeNodeAVL.remove(root, value);
	}
	
	public BinaryTreeNodeAVL getNode(int value) {
		return root.getNode(value);
	}
	
	public void avl() {
		setRoot(BinaryTreeNodeAVL.avl(root));
	}
	
	public int getHeight() {
		return BinaryTreeNodeAVL.getHeight(root);
	}
	
	public int getBalancing() {
		return root.getBalancing();
	}
	
	public String toString() {
		return root.toString();
	}

}

package árvore_binária;

public class BinaryTreeNode {
	
	private Integer data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode() {
		this.data = null;
		this.left = null;
	}
	
	public BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	
	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public void insert(int value) {
		if (data == null) {
			data = value;
		} else if (data.intValue() <= value) {
			if (right == null) {
				right = new BinaryTreeNode();
			}
			right.insert(value);
		} else {
			if (left == null) {
				left = new BinaryTreeNode();
			}
			left.insert(value);
		}
	}
	
	public static BinaryTreeNode remove(BinaryTreeNode node, int value) {
		if (node == null) {
			return null;
		}
		
		if (node.getData().intValue() > value) {
			node.setLeft(remove(node.getLeft(), value));
		} else if (node.getData().intValue() < value) {
			node.setRight(remove(node.getRight(), value));
		} else { // this node must be deleted
			
			// has one child cases
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			}
			
			// balances the subtree
			node.setData(getMinValue(node.getRight()));
			node.setRight(remove(node.getRight(), node.getData()));
		}
		
		return node;
	}
	
	public BinaryTreeNode getNode(int value) {
		if (data == null) {
			return null;
		}
		
		if (data > value && left != null) {
			return left.getNode(value);
		} else if (data < value && right != null) {
			return right.getNode(value);
		} else if (data == value) {
			return this;
		} else {
			return null;
		}
	}
	
	public int getBalancing() {
		return getHeight(left) - getHeight(right);
	}
	
	public String toString() {
		String text = "";
		if (data != null) {
			text += data.toString();
		}
		if (left != null) {
			text += "{" + left.toString() + "}";
		} else if (right != null) {
			text += "{" + "}";
		}
		if (right != null) {
			text += "{" + right.toString() + "}";
		} else if (left != null) {
			text += "{" + "}";
		}
		return text;
	}
	
	public static int getHeight(BinaryTreeNode node) {
		if (node == null) {
			return -1;
		}
		
		int leftHeight = getHeight(node.getLeft());
		int rightHeight = getHeight(node.getRight());
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	private static int getMinValue(BinaryTreeNode node) {
		int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
	}
	
}

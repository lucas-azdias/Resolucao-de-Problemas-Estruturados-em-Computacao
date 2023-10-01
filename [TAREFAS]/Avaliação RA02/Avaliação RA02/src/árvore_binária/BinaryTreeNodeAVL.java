package árvore_binária;

public class BinaryTreeNodeAVL {
	
	private Integer data;
	private BinaryTreeNodeAVL left;
	private BinaryTreeNodeAVL right;
	
	public BinaryTreeNodeAVL() {
		this.data = null;
		this.left = null;
	}
	
	public BinaryTreeNodeAVL(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTreeNodeAVL(int data, BinaryTreeNodeAVL left, BinaryTreeNodeAVL right) {
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

	public BinaryTreeNodeAVL getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNodeAVL left) {
		this.left = left;
	}
	
	public BinaryTreeNodeAVL getRight() {
		return right;
	}

	public void setRight(BinaryTreeNodeAVL right) {
		this.right = right;
	}

	public static BinaryTreeNodeAVL insert(BinaryTreeNodeAVL node, int value) {
		if (node == null) {
			return null;
		}
		
		Integer data = node.getData();
		BinaryTreeNodeAVL left = node.getLeft();
		BinaryTreeNodeAVL right = node.getRight();
		if (data == null) {
			node.setData(value);;
		} else if (data.intValue() <= value) {
			if (right == null) {
				right = new BinaryTreeNodeAVL();
			}
			node.setRight(insert(right, value));;
		} else {
			if (left == null) {
				left = new BinaryTreeNodeAVL();
			}
			node.setLeft(insert(left, value));;
		}
		
		node = nodeAvl(node);
		
		return node;
	}
	
	public static BinaryTreeNodeAVL remove(BinaryTreeNodeAVL node, int value) {
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
		
		node = nodeAvl(node);
		
		return node;
	}
	
	public BinaryTreeNodeAVL getNode(int value) {
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
	
	public static BinaryTreeNodeAVL avl(BinaryTreeNodeAVL node) {
		// balances the entire subtree of the initial node
		
		int balancing = node.getBalancing();
		if (balancing == 2 || balancing == -2) { // this node is hanging to a side
			node = nodeAvl(node);
		} else if (balancing > 2) { // this node's sub-node is hanging to the left
			node.setLeft(nodeAvl(node.getLeft()));
		} else if (balancing < -2) { // this node's sub-node is hanging to the right
			node.setRight(nodeAvl(node.getRight()));
		}
		return node;
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
	
	public int getBalancing() {
		return getHeight(left) - getHeight(right);
	}
	
	public static int getHeight(BinaryTreeNodeAVL node) {
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
	
	private static BinaryTreeNodeAVL nodeAvl(BinaryTreeNodeAVL node) {
		// only balances for the current node
		
		if (node == null) {
			return null;
		}
		
		int balancing = node.getBalancing();
		BinaryTreeNodeAVL lastRoot = node, temp;
		if (balancing == 2) { // this node is hanging to the left
			// rotate to right
			node = node.getLeft();
			temp = node.getRight();
			node.setRight(lastRoot);
			lastRoot.setLeft(temp);
		} else if (balancing == -2) { // this node is hanging to the right
			// rotate to left
			node = node.getRight();
			temp = node.getLeft();
			node.setLeft(lastRoot);
			lastRoot.setRight(temp);
		}
		
		return node;
	}
	
	private static int getMinValue(BinaryTreeNodeAVL node) {
		int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
	}
	
}

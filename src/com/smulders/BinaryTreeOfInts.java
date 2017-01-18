package com.smulders;

public class BinaryTreeOfInts {
	private TreeNode root;
	
	public int countNodes() {
		return countNodesInternal(this.root);
	}
	
	private int countNodesInternal(TreeNode node) {
		int count = 1;
		if (node.left != null) {
			count = count + countNodesInternal(node.left);
		}
		if (node.right != null) {
			count = count + countNodesInternal(node.right);
		}
		return count;
	}
}

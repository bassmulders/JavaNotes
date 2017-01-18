package com.smulders;

public class BinaryTreeOfInts {
	private TreeNode root;
	
	public int countNodes() {
		return countNodesInternal(this.root);
	}
	
	private int countNodesInternal(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int count = 1;
			if (root.left != null) {
				count += countNodesInternal(root.left);
			}
			if (root.right != null) {
				count += countNodesInternal(root.right);
			}
			return count;
		}
	}
}

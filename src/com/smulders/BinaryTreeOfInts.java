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
	
	public void insert(int newItem) {
		this.root =  insertInternal(this.root, newItem);
	}
	
	private TreeNode insertInternal(TreeNode root, int newItem) {
		TreeNode newNode = new TreeNode(newItem);
		if (root == null) {
			return newNode;
		} else {
			if (newItem <= root.item) {
				root.left = insertInternal(root.left, newItem);
			} else {
				root.right = insertInternal(root.right, newItem);
			}
			return root;
		}
	}
	
	public boolean contains(int searchItem) {
		return containsInternal(this.root, searchItem);
	}
	
	private boolean containsInternal(TreeNode root, int searchItem) {
		if (root == null) 
			return false;
		if (searchItem == root.item)
			return true;
		if (searchItem <= root.item)
			return containsInternal(root.left, searchItem);
		else
			return containsInternal(root.right, searchItem);
	}
	
	public void print() {
		printInternal(this.root, 0);
	}
	
	private void printInternal(TreeNode root, int level) {
		if (root == null) {
			//System.out.println("level: " + level + "; value: " + "null");
			return;
		}
		printInternal(root.left, ++level);
		System.out.println("level: " + level + "; value: " + root.item);
		printInternal(root.right, level);
	}
}

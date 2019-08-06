package com.bobroccoli.tree;

public class DiameterofBinaryTree543 {
	int res;
	public int diameterOfBinaryTree(TreeNode root) {
		res = 1;
		depth(root);
		return res - 1;
	}
	private int depth(TreeNode root) {
		if(root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		res = Math.max(res, left+right+1);
		return Math.max(left, right)+1;
	}
}

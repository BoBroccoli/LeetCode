package com.bobroccoli.tree;

public class ConvertBSTtoGreaterTree538 {
	int res = 0;
	public TreeNode convertBST(TreeNode root) {
		if (root != null) {
			convertBST(root.right);
			res += root.val;
			root.val = res;
			convertBST(root.left);
		}
		return root;
	}
}

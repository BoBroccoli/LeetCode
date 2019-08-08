package com.bobroccoli.tree;

public class PathSumIII437 {
	int res = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		helper(root, sum);
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return res;
	}

	public void helper(TreeNode root, int sum) {
		if (root != null) {
			if (sum - root.val == 0) {
				++res;
			}
			helper(root.left, sum - root.val);
			helper(root.right, sum - root.val);
		}
	}
}

package com.bobroccoli;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class BinaryTreePreorderTraversal144 {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
        	return res;
        stack.add(root);
        while (!stack.isEmpty()) {
        	TreeNode topNode = stack.pop();
        	res.add(topNode.val);
        	if(topNode.right != null)
        		stack.add(topNode.right);
        	if (topNode.left != null) {
				stack.add(topNode.left);
			}
		}
        return res;
    }
}

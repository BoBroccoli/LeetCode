package com.bobroccoli.divideconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class MostFrequentSubtreeSum508 {
	public int max = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (root == null)
			return new int[0];
		max = 0;
		sumTree(root, map);
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			max = max < e.getValue() ? e.getValue() : max;
		}
		List<Integer> res = new ArrayList<Integer>();

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == max)
				res.add(e.getKey());
		}
		int[] array = new int[res.size()];
		for (int i = 0; i < res.size(); ++i)
			array[i] = res.get(i);
		return array;
	}

	private int sumTree(TreeNode root, Map<Integer, Integer> map) {
		if (root == null)
			return 0;
		int sumLeft = sumTree(root.left, map);
		int sumRight = sumTree(root.right, map);
		int res = sumLeft + sumRight + root.val;
		map.put(res, map.getOrDefault(res, 0) + 1);
		max = max < map.get(res) ? map.get(res) : max;
		return res;
	}
}

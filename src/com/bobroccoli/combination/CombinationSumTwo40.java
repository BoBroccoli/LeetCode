package com.bobroccoli.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[candidates.length];
		helper(res, list, candidates, visited, target, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, boolean[] visited, int target,
			int start) {
		if (target == 0) {
			res.add(new ArrayList(list));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (!visited[i] && i - 1 >= 0 && candidates[i - 1] == candidates[i] && !visited[i - 1]) {
				continue;
			}
			visited[i] = true;
			list.add(candidates[i]);
			helper(res, list, candidates, visited, target - candidates[i], i + 1);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}

package com.bobroccoli.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutationtwo47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		helper(res, list, nums, visited);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i - 1 >= 0 && !visited[i - 1] && nums[i] == nums[i - 1])
				continue;
			if (visited[i])
				continue;
			list.add(nums[i]);
			visited[i] = true;
			helper(res, list, nums, visited);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}
}

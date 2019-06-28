package com.bobroccoli.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null)
			return res;
		Arrays.sort(nums);//Remember to sort it1!!!!!!
		List<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		helper(res, nums, visited, list, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> list, int start) {
		res.add(new ArrayList<Integer>(list));
		for (int i = start; i < nums.length; i++) {
			if (i - 1 >= 0 && nums[i - 1] == nums[i] && !visited[i - 1])
				continue;
			list.add(nums[i]);
			visited[i] = true;
			helper(res, nums, visited, list, i + 1);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}

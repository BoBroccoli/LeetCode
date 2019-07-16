package com.bobroccoli.dfs;

public class PartitionToKEqualSumSubsets698 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return false;
		int total = 0;
		for (int i : nums)
			total += i;
		if (total % k != 0)
			return false;
		boolean[] visited = new boolean[nums.length];
		return helper(nums, 0, 0, total / k, 0, total, visited);
	}

	private boolean helper(int[] nums, int curSum, int totalSum, int part, int start, int total, boolean[] visited) {
		if (curSum == part)
			return helper(nums, 0, totalSum, part, 0, total, visited);
		if (totalSum == total)
			return true;
		for (int i = start; i < nums.length; ++i) {
			if (!visited[i] && curSum + nums[i] <= part) {
				visited[i] = true;
				if (helper(nums, curSum + nums[i], totalSum + nums[i], part, i + 1, total, visited))
					return true;
				visited[i] = false;
			}
		}
		return false;
	}
}

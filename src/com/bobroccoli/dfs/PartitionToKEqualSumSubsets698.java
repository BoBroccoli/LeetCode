package com.bobroccoli.dfs;

public class PartitionToKEqualSumSubsets698 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int sum = 0;
		for(int i : nums) {
			sum += i;
		}
		if(sum % k != 0)
			return false;
		boolean[] visited = new boolean[nums.length];
		return helper(nums, visited, sum/k, k, 0, 0);
	}

	private boolean helper(int[] nums, boolean[] visited, int partial, int k, int curSum, int start) {
		if(k == 1)
			return true;
		if(curSum == partial)
			return helper(nums, visited, partial, k-1, 0, 0);
		for(int i = start; i < nums.length; ++i) {
			if(!visited[i] && curSum+nums[i] <= partial) {
                visited[i] = true;
				if(helper(nums, visited, partial, k, curSum+nums[i], start+1))
					return true;
                visited[i] = false;
			}
		}
		return false;
	}
}

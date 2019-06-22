package com.bobroccoli.dynamic;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		//so find the subset add up to the half of the total
		int total = 0;
		for(int i : nums) {
			total += i;
		}
		if(total%2 == 1)
			return false;
		int aim = total/2;
		boolean[] res = new boolean[aim+1];
		res[0] = true;
		for(int i = 0; i < nums.length; i++) {
			for(int j = aim; j >= nums[i]; j--) {
				res[j] = res[j] || res[j-nums[i]];
			}
		}
		return res[aim];
	}
}

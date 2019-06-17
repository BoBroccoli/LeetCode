package com.bobroccoli.greedy;

public class WiggleSubsequence376 {
	public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int j = 1, b = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1])
                j = b+1;
            else if(nums[i] < nums[i-1])
                b = j+1;
        }
        return Math.max(b, j);
    }
}

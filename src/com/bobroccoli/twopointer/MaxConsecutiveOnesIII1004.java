package com.bobroccoli.twopointer;

public class MaxConsecutiveOnesIII1004 {
	public int longestOnes(int[] A, int K) {
		//1 1 1 0 0 0 1 1 1 1 0
		int left = 0, res = 0, count = 0;
		for(int right = 0; right < A.length; ++right) {
			if(A[right] == 0)
				++count;
			while(count > K) {
				if(A[left] == 0)
					--count;
				++left;
			}
			res = Math.max(res, right-left+1);
		}
		return res;
	}
}

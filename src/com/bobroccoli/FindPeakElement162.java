package com.bobroccoli;

public class FindPeakElement162 {

	public int findPeakElement(int[] nums) {
		return search(0, nums.length-1, nums);
	}
	public int search(int l, int r, int[] nums){
        if(l == r)
            return l;
        int mid = (l + r)/2;
        if(nums[mid] > nums[mid+1])
            return search(l, mid, nums);
        return search(mid+1, r, nums);
    }
}

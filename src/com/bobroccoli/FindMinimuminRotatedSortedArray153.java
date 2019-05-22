package com.bobroccoli;

public class FindMinimuminRotatedSortedArray153 {
	public int findMin(int[] nums) {
        //min in left or right
        //4,5,6,7,0,1,2
        int res = Integer.MAX_VALUE;
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            //min in left
            if(nums[start] > nums[mid] || nums[start] < nums[mid] && nums[start] < nums[end])
                end = mid-1;
            else
                start = mid+1;
            res = Math.min(res, nums[mid]);
        }
        
        return res;
    }
}

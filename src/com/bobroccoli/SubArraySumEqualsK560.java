package com.bobroccoli;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
    	int res = 0, sum = 0;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if(map.containsKey(sum))
    			res += map.get(sum-k);
    		map.put(sum, map.getOrDefault(sum, 0)+1);
    	}
    	return res;
    }
}

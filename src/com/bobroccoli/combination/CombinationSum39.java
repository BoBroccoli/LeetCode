package com.bobroccoli.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, candidates, target, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(res, list, candidates, target-candidates[i], i);
            list.remove(list.size()-1);
        }
    }
}

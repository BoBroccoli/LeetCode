package com.bobroccoli.dfs;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence842 {
	public List<Integer> splitIntoFibonacci(String S) {
		//123 456 579
		List<Integer> res = new ArrayList<Integer>();
		helper(res, S, 0);
		return res;
	}

	private boolean helper(List<Integer> res, String s, int start) {
		if(start == s.length() && res.size()>=3)
			return true;
		for(int i = start; i < s.length(); ++i) {
			if(s.charAt(start)=='0' && i > start)
				break;
			Long part = Long.parseLong(s.substring(start, i+1));
			if(res.size() >= 2 && res.get(res.size()-2)+res.get(res.size()-1) < part)
				break;
			if(part > Integer.MAX_VALUE)
				break;
			if(res.size() < 2 || res.get(res.size()-2)+res.get(res.size()-1) == part){
				res.add(part.intValue());
				if(helper(res, s, i+1)) {
					return true;
				}
				res.remove(res.size()-1);
			}
		}
		return false;
	}
}

package com.bobroccoli.divideconquer;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author wenxx
 *need improve running time, substring class, map and two pointer
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters395 {
	public int longestSubstring(String s, int k) {
		int res = 0;
		res = helper(s, k);
		return res;
	}

	public int helper(String s, int k) {
		if (s == null || s.length() < k)
			return 0;
		int res = 0, left = 0, right = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> newmap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		for (; right < s.length(); right++) {
			if (map.get(s.charAt(right)) >= k) {
				newmap.put(s.charAt(right), newmap.getOrDefault(s.charAt(right), 0) + 1);
			} else {
				res = Math.max(res, helper(s.substring(left, right), k));
				res = Math.max(res, helper(s.substring(right + 1, s.length()), k));
				left = right + 1;
				newmap.clear();
			}
		}
		if (left == 0 && right == s.length())
			return s.length();
		return res;
	}
}

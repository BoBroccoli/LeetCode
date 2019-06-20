package com.bobroccoli.substring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		int res = 0, left = 0;
		Set<Character> set = new HashSet<Character>();
		for (int right = 0; right < s.length(); right++) {
			if (!set.contains(s.charAt(right))) {
				res = Math.max(res, right - left + 1);
			} else {
				while (set.contains(s.charAt(right))) {
					set.remove(s.charAt(left));
					left++;
				}
			}
			set.add(s.charAt(right));
		}
		return res;
	}
}
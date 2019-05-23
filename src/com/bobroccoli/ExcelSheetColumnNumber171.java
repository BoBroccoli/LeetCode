package com.bobroccoli;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber171 {
	public int titleToNumber(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < 26; i++) {
			char c = (char) ('A' + i);
			map.put(c, i + 1);
		}
		int result = 0;
		int base = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			result += map.get(c) * base;
			base *= 26;
		}
		return result;
	}
}

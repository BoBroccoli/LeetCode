package com.bobroccoli.combination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
			return list;
		String[] s = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> strings = new ArrayList<String>();
		for (Character c : digits.toCharArray()) {
			strings.add(s[c - '0']);
		}
		String string = "";
		helper(list, strings, string, 0);
		return list;
	}

	public void helper(List<String> list, List<String> strings, String string, int start) {
		if (string.length() == strings.size()) {
			list.add(string);
			return;
		}
		for (int i = start; i < strings.size(); ++i) {
			for (int j = 0; j < strings.get(i).length(); ++j) {
				string += strings.get(i).charAt(j);
				helper(list, strings, string, i + 1);
				string = string.substring(0, string.length() - 1);
			}
		}
	}
}

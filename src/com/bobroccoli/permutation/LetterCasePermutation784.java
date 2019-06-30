package com.bobroccoli.permutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        if(S == null || S.length() == 0)
            return res;
        char[] chars = S.toCharArray();
        helper(res, chars, 0);
        return res;
    }

	private void helper(List<String> res, char[] chars, int i) {
		if(i == chars.length) {
			res.add(new String(chars));
			return;
		}
			if(!Character.isLetter(chars[i])) {
			helper(res, chars, i+1);
			return;
		}
		chars[i] = Character.toUpperCase(chars[i]);
		helper(res, chars, i+1);
		chars[i] = Character.toLowerCase(chars[i]);
		helper(res, chars, i+1);
	}
}

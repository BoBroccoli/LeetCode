package com.bobroccoli.dfs;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationLint779 {
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word == null || word.length() == 0)
            return res;
        
        helper(res, "", 0, word);
        return res;
    }

	private void helper(List<String> res, String string, int position, String word) {
		if(position == word.length()) {
			res.add(string);
			return;
		}
		if(position == 0) {
			helper(res, word.substring(0,1), position+1, word);
			helper(res, "1", position+1, word);
		}
		else {
			if(string.charAt(position-1)>='0' && string.charAt(position-1)<='9') {
				int num = string.charAt(position-1)-'0';
				int i = string.length()-2, product = 10;
				while (i>= 0 && string.charAt(i) >='0' && string.charAt(i)<='9') {
					int val = string.charAt(i)-'0';
					val *= product;
					product *= 10;
					--i;
					num += val;
				}
				helper(res, string.substring(0, i+1)+num, position+1, word);
				helper(res, string+string.charAt(position), position+1, word);
			}
			else {
				helper(res, string+'1', position+1, word);
				helper(res, string+word.charAt(position), position+1, word);
			}
		}
	}
}
